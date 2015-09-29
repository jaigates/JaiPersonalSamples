package com.TEST0123;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_TEST0123 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		TEST0123DAO dao1 = (TEST0123DAO) context.getBean("TEST0123DAO");

		String IN_GUID = "qwertyuiop";
		String SQLCODE_PARM = "SQLCODE_PARM";
		String RESP_CODE = "RESP_CODE";
		String RESP_MSG = "RESP_MSG";


		Map<String, Object> result = dao1.getResult(IN_GUID, SQLCODE_PARM, RESP_CODE, RESP_MSG);
		System.out.println(result);

		/* Sample data
		 {SQLCODE_PARM=100       , RESP_MSG=GUID NOT FOUND                                                                                      , RESP_CODE=SSEAB001                 }

		 */
	}
}
