package com.jai.TEST0118;

import java.util.Map;

import javax.sql.DataSource;

public interface TEST0118DAO {

	public abstract void setDataSource(DataSource source);

	public Map<String, Object> getResult(String guid, String iN_MICRODEBIT_FLAG, String iN_PLAID_FLAG, Integer iN_RETRY_CNT);

}