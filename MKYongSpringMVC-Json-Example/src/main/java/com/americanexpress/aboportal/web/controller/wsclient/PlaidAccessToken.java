package com.americanexpress.aboportal.web.controller.wsclient;

import org.codehaus.jackson.annotate.JsonProperty;

public class PlaidAccessToken extends PlaidBaseResponse {

	private String accessToken;

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
