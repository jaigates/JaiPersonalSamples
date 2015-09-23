package com.americanexpress.aboportal.web.service.impl.plaid.PlaidServiceImpl;

import com.americanexpress.aboportal.web.controller.wsclient.AccountResponseDTO;

public interface PlaidService {

	public abstract AccountResponseDTO getAccountDetails(String publicToken);

}