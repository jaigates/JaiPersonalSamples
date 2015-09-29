package com.TEST0117;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_TEST0117 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		TEST0117DAO dao1 = (TEST0117DAO) context.getBean("TEST0117DAO");
		Map<String, Object> result = dao1.getResult("qwertyuiop");
		System.out.println(result);

	}
	
	/* sample output {#result-set-1=[
	 * {ACCT_ID=a3726ddf-fc55-4119-b1f1-a4639afb1604, ACCT_NO=12345678, ACCT_RTE_NO=062111080, MICRO_DR_CNFR_RETRY_CT=3, PYMT_USD_AM_1=0.67, PYMT_USD_AM_2=0.33,BANK_NM=Chase}],
	 *  RESP_CD=SSEAB000, SQLCODE_PARM=0 , RESP_MSG=MICRODEBITDETAILS RETRIEVED}*/
	
}
