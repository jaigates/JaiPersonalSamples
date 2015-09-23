package com.mkyong.service.dto;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.annotate.JsonProperty;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountsResponseDTO {

	private String bankName;
	private String accountNumber;
	private String routingNumber;

	/**
	 * @return the accountNumber
	 */
	@JsonProperty("number")
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the bankName
	 */
	@JsonProperty("name")
	public String getBankName() {
		return bankName;
	}

	/**
	 * @return the routingNumber
	 */
	@JsonProperty("routing")
	public String getRoutingNumber() {
		return routingNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @param bankName
	 *            the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @param routingNumber
	 *            the routingNumber to set
	 */
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}
}
