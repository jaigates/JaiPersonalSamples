package com.TEST0117;

import java.util.Map;

import javax.sql.DataSource;

public interface TEST0117DAO {

	public abstract void setDataSource(DataSource source);

	public Map<String, Object> getResult(String guid);

}