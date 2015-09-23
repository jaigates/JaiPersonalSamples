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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.americanexpress.aboportal.web.controller.wsclient.AccountResponseDTO;
import com.americanexpress.aboportal.web.controller.wsclient.PlaidAccessToken;
import com.americanexpress.aboportal.web.controller.wsclient.PlaidRequestDTO;
import com.americanexpress.aboportal.web.utils.ReloadablePropertiesUtils;

@Service
@Configuration()
public class PlaidServiceImpl implements PlaidService {

	private static Logger logger = Logger.getLogger(PlaidServiceImpl.class);

	private String PROXY_HOST;
	private String ACCESS_TOKEN_URL;
	private String EXCHANGE_TOKEN_URL;
	private String CLIENT_ID;
	private String SECRET_KEY;
	private Boolean useHttpCredentials;
	private static String PROXY_USERNAME;
	private static String PROXY_PASSWORD;
	private Integer PROXY_PORT;
	
	
	@Autowired
	MessageSource messageSource;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.americanexpress.aboportal.web.service.impl.plaid.PlaidServiceImpl
	 * .PlaidService#getAccountDetails(java.lang.String)
	 */
	@Override
	public AccountResponseDTO getAccountDetails(String publicToken) {
		initProperties();
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
			ProxyAuthSecurityHandler proxyHandler = new ProxyAuthSecurityHandler(PROXY_USERNAME, PROXY_PASSWORD);
			clientConfig.handlers(proxyHandler);
			client = new RestClient(clientConfig);
		} else {
			logger.debug("Using NO PROXY");
			client = new RestClient(clientConfig);
		}

		Resource resource1 = client.resource(EXCHANGE_TOKEN_URL);
		resource1.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		PlaidRequestDTO exchangeTokenRequestDTO = new PlaidRequestDTO();
		exchangeTokenRequestDTO.setClientId(CLIENT_ID);
		exchangeTokenRequestDTO.setSecretKey(SECRET_KEY);
		exchangeTokenRequestDTO.setPublicToken(publicToken);
		logger.debug("Sending Exchange Token Request...");
		ClientResponse exchangeTokenResponse = resource1.accept(MediaType.APPLICATION_JSON).post(exchangeTokenRequestDTO);
		int statusCode = exchangeTokenResponse.getStatusCode();
		logger.debug("Received exchange token request with response code : " + statusCode);

		PlaidAccessToken accessToken = exchangeTokenResponse.getEntity(PlaidAccessToken.class);
		if (statusCode == 200) {
			Resource resource2 = client.resource(ACCESS_TOKEN_URL);
			PlaidRequestDTO requestDTO = new PlaidRequestDTO();
			requestDTO.setClientId(CLIENT_ID);
			requestDTO.setSecretKey(SECRET_KEY);
			requestDTO.setPublicToken(publicToken);
			requestDTO.setAccessToken(accessToken.getAccessToken());

			Resource accept = resource2.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
			ClientResponse response = accept.post(requestDTO);
			AccountResponseDTO accountResponse = response.getEntity(AccountResponseDTO.class);
			logger.debug("Received accountResponse request with response code : " + statusCode);
			if (statusCode == 200) {
				logger.debug("accountResponse request succeded. ");
				return accountResponse;
			} else {
				logger.debug("accountResponse request failed with message : " + accountResponse.getMessage() + ", resolve :" + accountResponse.getResolve());
				return accountResponse;
			}
		} else {
			logger.debug("Exchance token request failed with message : " + accessToken.getMessage() + ", resolve : " + accessToken.getResolve());
			AccountResponseDTO dto = new AccountResponseDTO();
			dto.setCode(accessToken.getCode());
			dto.setMessage(accessToken.getMessage());
			dto.setResolve(accessToken.getResolve());
			return dto;
		}
	}

	private void initProperties() {
		
		PROXY_HOST = messageSource.getMessage("http.proxy.host", null, null,null);
		ACCESS_TOKEN_URL = messageSource.getMessage("plaid.access_token_url", null, null,null);
		EXCHANGE_TOKEN_URL = messageSource.getMessage("plaid.exchange_url", null, null,null);
		CLIENT_ID = messageSource.getMessage("plaid.clientid", null, null,null);
		SECRET_KEY = messageSource.getMessage("plaid.secret", null, null,null);
		useHttpCredentials = Boolean.parseBoolean(messageSource.getMessage("http.useHttpCredentials", null, null,null));
		PROXY_USERNAME = messageSource.getMessage("http.username", null, null,null);
		PROXY_PASSWORD = messageSource.getMessage("http.password", null, null,null);
		PROXY_PORT = Integer.parseInt(messageSource.getMessage("http.proxy.port", null, "0",null));
		setProxy();
	}

	private void setProxy() {
		if (StringUtils.isNotEmpty(PROXY_HOST) && useHttpCredentials) {
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
		p.getAccountDetails("");
	}
}