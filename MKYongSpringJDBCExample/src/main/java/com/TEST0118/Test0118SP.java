package com.TEST0118;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

/*
 * Inner class to implement stored procedure in spring.
 */

public class Test0118SP extends StoredProcedure {

	private static final String SPROC_NAME = "TEST0118";
	private static final String IN_ACCT_ID = "IN_ACCT_ID";
	private static final String IN_MICRODEBIT_FLAG = "IN_MICRODEBIT_FLAG";
	private static final String IN_PLAID_FLAG = "IN_PLAID_FLAG";
	private static final String IN_RETRY_CNT = "IN_RETRY_CNT";
	private static final String RESP_CODE = "RESP_CODE";
	private static final String RESP_MSG = "RESP_MSG";
	private static final String SQLCODE_PARM = "SQLCODE_PARM";

	public Test0118SP(DataSource datasource) {
		super(datasource, SPROC_NAME);
		declareParameter(new SqlParameter(IN_ACCT_ID, Types.VARCHAR));
		declareParameter(new SqlParameter(IN_MICRODEBIT_FLAG, Types.VARCHAR));
		declareParameter(new SqlParameter(IN_PLAID_FLAG, Types.VARCHAR));
		declareParameter(new SqlParameter(IN_RETRY_CNT, Types.INTEGER));
		declareParameter(new SqlOutParameter(RESP_CODE, Types.VARCHAR));
		declareParameter(new SqlOutParameter(RESP_MSG, Types.VARCHAR));
		declareParameter(new SqlOutParameter(SQLCODE_PARM, Types.VARCHAR));
		compile();
	}

	public Test0118SP() {
	}

	public Map<String, Object> execute(String IN_ACCT_ID, String IN_MICRODEBIT_FLAG, String IN_PLAID_FLAG, Integer IN_RETRY_CNT) {
		Map<String, Object> results = super.execute(IN_ACCT_ID, IN_MICRODEBIT_FLAG, IN_PLAID_FLAG, IN_RETRY_CNT);
		return results;
	}
}