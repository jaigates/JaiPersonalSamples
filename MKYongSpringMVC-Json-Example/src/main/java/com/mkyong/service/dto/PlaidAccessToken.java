package com.mkyong.service.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class PlaidAccessToken {

	private String accessToken;

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
