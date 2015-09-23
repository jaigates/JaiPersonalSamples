package com.mkyong.common.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.americanexpress.aboportal.web.controller.wsclient.AccountDTO;
import com.americanexpress.aboportal.web.service.impl.plaid.PlaidServiceImpl.PlaidClientServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/plaid")
public class PlaidController {

	private static final Logger logger = LoggerFactory.getLogger(PlaidController.class);
	PlaidClientServiceImpl pService = new PlaidClientServiceImpl();

	@RequestMapping(value = "/getAccountDetails", method = RequestMethod.GET)
	public ModelAndView getAccountDetails(Model model, @RequestParam(value = "public_token", required = false) String publicToken) {
		ModelAndView mav = new ModelAndView();
		publicToken = StringUtils.stripToEmpty(publicToken);
		if (publicToken != null) {

			List<AccountDTO> accountDetails = pService.getAccountDetails(publicToken);
			if (accountDetails != null) {
				model.addAttribute("accounts", accountDetails);
				mav.setViewName("success");
			} else {
				String msg = "Account details is null";
				mav.addObject("errorMsg", msg);
				mav.setViewName("error");
			}
		} else {
			String msg = "public_token is empty";
			logger.error(msg);
			mav.addObject("errorMsg", msg);
			mav.setViewName("error");
		}
		return mav;
	}

}
