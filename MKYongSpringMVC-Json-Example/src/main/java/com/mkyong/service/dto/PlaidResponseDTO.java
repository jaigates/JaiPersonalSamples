package com.mkyong.service.dto;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
public class PlaidResponseDTO {

	private List<AccountsResponseDTO> accountDetails;

	/**
	 * @return the accountDetails
	 */
	public List<AccountsResponseDTO> getAccountDetails() {
		return accountDetails;
	}

	/**
	 * @param accountDetails
	 *            the accountDetails to set
	 */
	public void setAccountDetails(List<AccountsResponseDTO> accountDetails) {
		this.accountDetails = accountDetails;
	}

}
