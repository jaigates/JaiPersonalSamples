package com.americanexpress.aboportal.web.service.impl.plaid.PlaidServiceImpl;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

import com.americanexpress.aboportal.web.controller.wsclient.AccountDTO;
import com.americanexpress.aboportal.web.controller.wsclient.AccountResponseDTO;
import com.mkyong.service.dto.ClientApplication;
import com.mkyong.service.dto.PlaidAccessToken;
import com.mkyong.service.dto.PlaidRequestDTO;

public class PlaidClientServiceImpl {

	private static final String EXCHANGE_TOKEN_URL = "https://tartan.plaid.com/exchange_token";
	private static final String ACCESS_TOKEN_URL = "https://tartan.plaid.com/auth/get";
	private static final String CLIENT_ID = "5600a8b71abbf9e13f581f4c";
	private static final String SECRET_KEY = "e22d03c9b4526fae179703190ef215";

	private static Logger logger = Logger.getLogger(PlaidClientServiceImpl.class);

	static String PROXY_USERNAME = System.getProperty("proxyUsername");
	static String PROXY_PASSWORD = System.getProperty("proxyPassword");

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
		PlaidClientServiceImpl p = new PlaidClientServiceImpl();
		p.getAccountDetails("");
	}

	public List<AccountDTO> getAccountDetails(String publicToken) {
		ClientApplication clientApplication = new ClientApplication();
		Set<Object> s = new HashSet<Object>();
		s.add(new org.apache.wink.providers.jackson.WinkJacksonJaxbJsonProvider());
		// s.add(new org.apache.wink.providers.json.JsonProvider());
		clientApplication.setSingletons(s);
		ClientConfig clientConfig = new ClientConfig().applications(clientApplication);
		RestClient client = new RestClient(clientConfig);

		Resource resource1 = client.resource(EXCHANGE_TOKEN_URL);
		resource1.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		PlaidRequestDTO exchangeTokenRequestDTO = new PlaidRequestDTO();
		exchangeTokenRequestDTO.setClientId(CLIENT_ID);
		exchangeTokenRequestDTO.setSecretKey(SECRET_KEY);
		exchangeTokenRequestDTO.setPublicToken(publicToken);
		logger.debug("Exchange Token Request Start");

		// Response for getting Access Token.
		ClientResponse exchangeTokenResponse = resource1.accept(MediaType.APPLICATION_JSON).post(exchangeTokenRequestDTO);
		exchangeTokenResponse.getStatusCode();
		PlaidAccessToken accessToken = exchangeTokenResponse.getEntity(PlaidAccessToken.class);

		Resource resource2 = client.resource(ACCESS_TOKEN_URL);
		PlaidRequestDTO requestDTO = new PlaidRequestDTO();
		requestDTO.setClientId(CLIENT_ID);
		requestDTO.setSecretKey(SECRET_KEY);
		requestDTO.setPublicToken(publicToken);
		requestDTO.setAccessToken(accessToken.getAccessToken());

		Resource accept = resource2.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		ClientResponse response = null;
		response = accept.post(requestDTO);
		exchangeTokenResponse.getStatusCode();
		// System.out.println(response.getEntity(String.class));
		AccountResponseDTO accountResponse = response.getEntity(AccountResponseDTO.class);
		System.out.println(":" + accountResponse);
		System.out.println(":" + response);

		return accountResponse.getAccounts();

	}
}