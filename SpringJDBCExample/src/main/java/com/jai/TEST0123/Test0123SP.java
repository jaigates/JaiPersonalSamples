package com.jai.TEST0123;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/*
 * Inner class to implement stored procedure in spring.
 */

public class Test0123SP extends StoredProcedure {

	private static final String SPROC_NAME = "TEST0123";
	private static final String IN_GUID = "IN_GUID";
	private static final String SQLCODE_PARM = "SQLCODE_PARM";
	private static final String RESP_CODE = "RESP_CODE";
	private static final String RESP_MSG = "RESP_MSG";

	public Test0123SP(DataSource datasource) {
		super(datasource, SPROC_NAME);
		declareParameter(new SqlParameter(IN_GUID, Types.VARCHAR));
		declareParameter(new SqlOutParameter(SQLCODE_PARM, Types.VARCHAR));
		declareParameter(new SqlOutParameter(RESP_CODE, Types.VARCHAR));
		declareParameter(new SqlOutParameter(RESP_MSG, Types.VARCHAR));
		compile();
	}

	public Test0123SP() {
	}

	public Map<String, Object> execute(String IN_GUID, String SQLCODE_PARM, String RESP_CODE, String RESP_MSG) {
		try {
			Map<String, Object> results = super.execute(IN_GUID, SQLCODE_PARM, RESP_CODE, RESP_MSG);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}