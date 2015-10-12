package com.TEST0113;

import java.util.Map;

import javax.sql.DataSource;

public interface TEST0113DAO {

	public abstract void setDataSource(DataSource source);

	public Map<String, Object> getResult(Map<String,Object> inMap) throws Exception;

}