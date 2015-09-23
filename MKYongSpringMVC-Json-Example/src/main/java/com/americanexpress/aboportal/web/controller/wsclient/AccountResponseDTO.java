package com.americanexpress.aboportal.web.controller.wsclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "accounts", "access_token" })
public class AccountResponseDTO extends PlaidBaseResponse {

	@JsonProperty("accounts")
	private List<AccountDTO> accounts = new ArrayList<AccountDTO>();
	@JsonProperty("access_token")
	private String accessToken;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public AccountResponseDTO() {
	}

	/**
	 * 
	 * @param accounts
	 * @param accessToken
	 */
	public AccountResponseDTO(List<AccountDTO> accounts, String accessToken) {
		this.accounts = accounts;
		this.accessToken = accessToken;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof AccountResponseDTO) == false) {
			return false;
		}
		AccountResponseDTO rhs = ((AccountResponseDTO) other);
		return new EqualsBuilder().append(accounts, rhs.accounts).append(accessToken, rhs.accessToken).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

	/**
	 * 
	 * @return The accessToken
	 */
	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * 
	 * @return The accounts
	 */
	@JsonProperty("accounts")
	public List<AccountDTO> getAccounts() {
		return accounts;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(accounts).append(accessToken).append(additionalProperties).toHashCode();
	}

	/**
	 * 
	 * @param accessToken
	 *            The access_token
	 */
	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * 
	 * @param accounts
	 *            The accounts
	 */
	@JsonProperty("accounts")
	public void setAccounts(List<AccountDTO> accounts) {
		this.accounts = accounts;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
