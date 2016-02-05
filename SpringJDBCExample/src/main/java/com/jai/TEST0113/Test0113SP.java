package com.jai.TEST0113;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/*
 * Inner class to implement stored procedure in spring.
 */
public class Test0113SP extends StoredProcedure {

	private static final String SPROC_NAME = "TEST0113";
	private static final String IN_RSVP_CD = "IN_RSVP_CD";
	private static final String IN_ABO_EMAIL_AD_TX = "IN_ABO_EMAIL_AD_TX";
	private static final String IN_IND = "IN_IND";
	private static final String IN_GUID = "IN_GUID";
	private static final String SSE_ORG_ID = "SSE_ORG_ID";
	

	public Test0113SP(DataSource datasource) {
		super(datasource, SPROC_NAME);

		declareParameter(new SqlParameter(IN_RSVP_CD, Types.VARCHAR));
		declareParameter(new SqlParameter(IN_ABO_EMAIL_AD_TX, Types.VARCHAR));
		declareParameter(new SqlParameter(IN_IND, Types.VARCHAR));
		declareParameter(new SqlParameter(IN_GUID, Types.VARCHAR));
		declareParameter(new SqlParameter(SSE_ORG_ID, Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("SQLCODE_PARM", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESP_CODE", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESP_MSG", Types.VARCHAR));
		declareParameter(new SqlOutParameter("ABO_ACCT_RETRY_CNT", Types.INTEGER));
		declareParameter(new SqlOutParameter("RSVP_RETRY_CNT", Types.INTEGER));
		declareParameter(new SqlOutParameter("O_SSE_ORG_ID", Types.VARCHAR));
		declareParameter(new SqlOutParameter("O_ABO_FIRST_NM", Types.VARCHAR));
		
		compile();
	}

	/*public Map<String, Object> execute(Map<String,Object> inMap) {
		logger.info("Inside com.TEST0113.Test0113SP.execute(String)...");
		try {
			Map<String, Object> results = super.execute(inMap);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
}