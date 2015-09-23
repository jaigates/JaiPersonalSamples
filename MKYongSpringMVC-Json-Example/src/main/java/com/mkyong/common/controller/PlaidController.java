package com.mkyong.common.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.americanexpress.aboportal.web.controller.wsclient.AccountResponseDTO;
import com.americanexpress.aboportal.web.service.impl.plaid.PlaidServiceImpl.PlaidService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/plaid")
public class PlaidController {

	private static final Logger logger = LoggerFactory.getLogger(PlaidController.class);

	@Autowired
	PlaidService pService;

	@RequestMapping(value = "/getAccountDetails", method = RequestMethod.GET)
	public @ResponseBody
	AccountResponseDTO getAccountDetails(Model model, @RequestParam(value = "public_token", required = false) String publicToken) {
		AccountResponseDTO accountDetails = null;
		publicToken = StringUtils.stripToEmpty(publicToken);
		if (publicToken != null) {

			accountDetails = pService.getAccountDetails(publicToken);
			/*
			 * if (accountDetails != null) { model.addAttribute("accounts",
			 * accountDetails); mav.setViewName("success"); } else { String msg
			 * = "Account details is null"; mav.addObject("errorMsg", msg);
			 * mav.setViewName("error"); } } else { String msg =
			 * "public_token is empty"; logger.error(msg);
			 * mav.addObject("errorMsg", msg); mav.setViewName("error"); }
			 * return mav;
			 */

		}
		return accountDetails;
	}
}
