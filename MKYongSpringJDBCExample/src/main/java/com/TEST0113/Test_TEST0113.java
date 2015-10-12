package com.TEST0113;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_TEST0113 {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		TEST0113DAO dao1 = (TEST0113DAO) context.getBean("TEST0113DAO");
		Map<String,Object> inMap = new HashMap<String,Object>();
		inMap.put("IN_RSVP_CD","b2010101010");
		inMap.put("IN_ABO_EMAIL_AD_TX","abcd1@gmail.com");
		inMap.put("IN_IND","Y");
		
		inMap.put("IN_GUID","");
		inMap.put("SSE_ORG_ID","842bbbfd-2571-4387-b851-534a2584644c");
		
//		inMap.put("IN_GUID","");
//		inMap.put("SSE_ORG_ID","bbbb");
		
		Map<String, Object> result = dao1.getResult(inMap);
		System.out.println(result);

	}
	
	/* sample output {#result-set-1=[
	 * {ACCT_ID=a3726ddf-fc55-4119-b1f1-a4639afb1604, ACCT_NO=12345678, ACCT_RTE_NO=062111080, MICRO_DR_CNFR_RETRY_CT=3, PYMT_USD_AM_1=0.67, PYMT_USD_AM_2=0.33,BANK_NM=Chase}],
	 *  RESP_CD=SSEAB000, SQLCODE_PARM=0 , RESP_MSG=MICRODEBITDETAILS RETRIEVED}*/
	
}
 