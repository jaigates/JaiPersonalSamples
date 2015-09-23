package com.americanexpress.aboportal.web.service.impl.plaid.PlaidServiceImpl;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.apache.wink.client.handlers.ProxyAuthSecurityHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.americanexpress.aboportal.web.controller.wsclient.AccountResponseDTO;
import com.americanexpress.aboportal.web.controller.wsclient.PlaidRequestDTO;

@Service
@Configuration
@PropertySource("classpath:aboportal.properties")
public class PlaidServiceImpl implements PlaidService {

	@Value("${http.proxy.host}")
	private String PROXY_HOST;

	@Value("${plaid.access_token_url}")
	private String ACCESS_TOKEN_URL;

	@Value("${plaid.exchange_url}")
	private String EXCHANGE_TOKEN_URL;

	@Value("${plaid.clientid}")
	private String CLIENT_ID;

	@Value("${plaid.secret}")
	private String SECRET_KEY;

	@Value("${http.useHttpCredentials}")
	private String useHttpCredentials;

	@Value("${http.username}")
	private static String PROXY_USERNAME;

	@Value("${http.password}")
	private static String PROXY_PASSWORD;

	@Value("${http.proxy.port}")
	private Integer PROXY_PORT;

	private static Logger logger = Logger.getLogger(PlaidServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.americanexpress.aboportal.web.service.impl.plaid.PlaidServiceImpl
	 * .PlaidService#getAccountDetails(java.lang.String)
	 */
	@Override
	public AccountResponseDTO getAccountDetails(String publicToken) {
		setProxy();
		ClientApplication clientApplication = new ClientApplication();
		Set<Object> s = new HashSet<Object>();
		s.add(new org.apache.wink.providers.jackson.WinkJacksonJaxbJsonProvider());
		// s.add(new org.apache.wink.providers.json.JsonProvider());
		clientApplication.setSingletons(s);
		RestClient client = null;
		ClientConfig clientConfig = new ClientConfig().applications(clientApplication);
		PROXY_HOST = StringUtils.stripToEmpty(PROXY_HOST);
		if (StringUtils.isNotEmpty(PROXY_HOST)) {
			logger.debug("Using proxy :" + PROXY_HOST + ":" + PROXY_PORT);
			clientConfig.proxyHost(PROXY_HOST);
			clientConfig.proxyPort(PROXY_PORT);
			if (Boolean.parseBoolean(useHttpCredentials)) {
				ProxyAuthSecurityHandler proxyHandler = new ProxyAuthSecurityHandler(PROXY_USERNAME, PROXY_PASSWORD);
				clientConfig.handlers(proxyHandler);
			}
			client = new RestClient(clientConfig);
		} else {
			logger.debug("Using NO PROXY");
			client = new RestClient(clientConfig);
		}

		AccountResponseDTO placeExchangeTokenRequest = placeExchangeTokenRequest(publicToken, client);
		if (placeExchangeTokenRequest.getCode() == 200) {
			return placeAccessTokenRequest(client, publicToken, placeExchangeTokenRequest);
		} else {
			logger.debug("Exchance token request failed with message : " + placeExchangeTokenRequest.getMessage() + ", resolve : " + placeExchangeTokenRequest.getResolve());
			AccountResponseDTO dto = new AccountResponseDTO();
			dto.setCode(placeExchangeTokenRequest.getCode());
			dto.setMessage(placeExchangeTokenRequest.getMessage());
			dto.setResolve(placeExchangeTokenRequest.getResolve());
			return dto;
		}
	}

	private AccountResponseDTO placeExchangeTokenRequest(String publicToken, RestClient client) {
		Resource exchangeTokenResouse = client.resource(EXCHANGE_TOKEN_URL);
		exchangeTokenResouse.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		PlaidRequestDTO exchangeTokenRequestDTO = new PlaidRequestDTO();
		exchangeTokenRequestDTO.setClientId(CLIENT_ID);
		exchangeTokenRequestDTO.setSecretKey(SECRET_KEY);
		exchangeTokenRequestDTO.setPublicToken(publicToken);
		logger.debug("Sending Exchange Token Request...");
		Resource accept = exchangeTokenResouse.accept(MediaType.APPLICATION_JSON);
		ClientResponse exchangeTokenResponse = accept.post(exchangeTokenRequestDTO);
		int statusCode = exchangeTokenResponse.getStatusCode();
		AccountResponseDTO accessToken = exchangeTokenResponse.getEntity(AccountResponseDTO.class);
		accessToken.setCode(statusCode);
		logger.debug("Received exchange token request with response code : " + statusCode);
		return accessToken;

	}

	private AccountResponseDTO placeAccessTokenRequest(RestClient client, String publicToken, AccountResponseDTO accessToken) {
		Resource accessTokenResource = client.resource(ACCESS_TOKEN_URL);
		PlaidRequestDTO requestDTO = new PlaidRequestDTO();
		requestDTO.setClientId(CLIENT_ID);
		requestDTO.setSecretKey(SECRET_KEY);
		requestDTO.setPublicToken(publicToken);
		requestDTO.setAccessToken(accessToken.getAccessToken());

		Resource accept = accessTokenResource.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		ClientResponse response = accept.post(requestDTO);
		AccountResponseDTO accountResponse = response.getEntity(AccountResponseDTO.class);
		int statusCode = response.getStatusCode();
		accountResponse.setCode(statusCode);
		logger.debug("Received accountResponse request with response code : " + statusCode);
		if (statusCode == 200) {
			logger.debug("accountResponse request succeded. ");
			return accountResponse;
		} else {
			logger.debug("accountResponse request failed with message : " + accountResponse.getMessage() + ", resolve :" + accountResponse.getResolve());
			return accountResponse;
		}
	}

	private void setProxy() {
		if (StringUtils.stripToEmpty(PROXY_HOST) != null && Boolean.parseBoolean(useHttpCredentials)) {
			final String authUser = PROXY_USERNAME;
			final String authPassword = PROXY_PASSWORD;
			Authenticator.setDefault(new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(authUser, authPassword.toCharArray());
				}
			});

			System.setProperty("http.proxyUser", authUser);
			System.setProperty("http.proxyPassword", authPassword);
		}
	}

	public static void main(String[] args) {

		Authenticator.setDefault(new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				if (getRequestorType() == Authenticator.RequestorType.PROXY) {

					return new PasswordAuthentication(PROXY_USERNAME, PROXY_PASSWORD.toCharArray());
				} else
					return super.getPasswordAuthentication();
			}
		});

		// getPojo();
		PlaidServiceImpl p = new PlaidServiceImpl();
		p.PROXY_HOST = "";
		p.ACCESS_TOKEN_URL = "https://tartan.plaid.com/auth/get";
		p.EXCHANGE_TOKEN_URL = "https://tartan.plaid.com/exchange_token";
		p.CLIENT_ID = "5600a8b71abbf9e13f581f4c";
		p.SECRET_KEY = "e22d03c9b4526fae179703190ef215";
		p.useHttpCredentials = "false";
		AccountResponseDTO accountDetails = p.getAccountDetails("3a2d3b387b0ee5d64283d5399eb8432d057677430c3f83daee0fa3603f0e85c4feda01bfe2bbeea386e3e983ba58ea8a27a253f951b072e59a07a9e53289d8b3");
		System.out.println(accountDetails);
	}
}