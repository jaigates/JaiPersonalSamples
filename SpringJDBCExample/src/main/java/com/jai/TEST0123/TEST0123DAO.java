package com.jai.TEST0123;

import java.util.Map;

import javax.sql.DataSource;

public interface TEST0123DAO {

	public abstract void setDataSource(DataSource source);

	public Map<String, Object> getResult(String IN_GUID, String SQLCODE_PARM, String RESP_CODE, String RESP_MSG);

}