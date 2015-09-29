package com.TEST0118;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_TEST0118 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		TEST0118DAO dao1 = (TEST0118DAO) context.getBean("TEST0118DAO");
		String IN_ACCT_ID = "a2035fb1-52f4-4833-9ff8-b91ee9fde969";
		String IN_MICRODEBIT_FLAG = "N";
		String IN_PLAID_FLAG = "Y";
		Integer IN_RETRY_CNT = 0;
		String RESP_CODE = "RESP_CODE";
		String RESP_MSG = "RESP_MSG";
		String SQLCODE_PARM = "SQLCODE_PARM";

		Map<String, Object> result = dao1.getResult(IN_ACCT_ID, IN_MICRODEBIT_FLAG, IN_PLAID_FLAG, IN_RETRY_CNT);
		System.out.println(result);

		/* Sample data
		[00:50:26,604] [TRACE] [main] [StatementCreatorUtils:207] - Setting SQL statement parameter value: column index 1, parameter value [a2035fb1-52f4-4833-9ff8-b91ee9fde969], value class [java.lang.S
        tring], SQL type 12
        [00:50:26,604] [TRACE] [main] [StatementCreatorUtils:207] - Setting SQL statement parameter value: column index 2, parameter value [N], value class [java.lang.String], SQL type 12
        [00:50:26,604] [TRACE] [main] [StatementCreatorUtils:207] - Setting SQL statement parameter value: column index 3, parameter value [Y], value class [java.lang.String], SQL type 12
        [00:50:26,604] [TRACE] [main] [StatementCreatorUtils:207] - Setting SQL statement parameter value: column index 4, parameter value [0], value class [java.lang.Integer], SQL type 4
        [00:50:37,797] [DEBUG] [main] [JdbcTemplate:1075] - CallableStatement.execute() returned 'false'
        [00:50:37,797] [DEBUG] [main] [JdbcTemplate:1076] - CallableStatement.getUpdateCount() returned -1
        [00:50:37,797] [DEBUG] [main] [DataSourceUtils:327] - Returning JDBC Connection to DataSource
        {SQLCODE_PARM=MICRODEBIT CONFIRMED                                                , RESP_MSG=SSEAB001                 , RESP_CODE=0         }
        */
	}
}
