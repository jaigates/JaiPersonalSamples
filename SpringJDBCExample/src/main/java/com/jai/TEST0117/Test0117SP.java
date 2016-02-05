package com.jai.TEST0117;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/*
 * Inner class to implement stored procedure in spring.
 */
public class Test0117SP extends StoredProcedure {

	private static final String SPROC_NAME = "TEST0117";
	private static final String IN_GUID = "IN_GUID";
	private static final String SQLCODE_PARM = "SQLCODE_PARM";
	private static final String RESP_CD = "RESP_CD";
	private static final String RESP_MSG = "RESP_MSG";

	public Test0117SP(DataSource datasource) {
		super(datasource, SPROC_NAME);

		declareParameter(new SqlParameter(IN_GUID, Types.VARCHAR));
		declareParameter(new SqlOutParameter(SQLCODE_PARM, Types.VARCHAR));
		declareParameter(new SqlOutParameter(RESP_CD, Types.VARCHAR));
		declareParameter(new SqlOutParameter(RESP_MSG, Types.VARCHAR));
		compile();
	}

	public Map<String, Object> execute(String guid) {
		Map<String, Object> results = super.execute(guid);
		return results;
	}
}