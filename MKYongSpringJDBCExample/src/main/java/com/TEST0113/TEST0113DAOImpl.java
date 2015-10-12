package com.TEST0113;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TEST0113DAOImpl implements TEST0113DAO {

	private JdbcTemplate jdbcTemplate;
	private Test0113SP sproc;

	public void setDataSource(DataSource source) {
		this.jdbcTemplate = new JdbcTemplate(source);
		this.sproc = new Test0113SP(jdbcTemplate.getDataSource());
	}

	public Map<String, Object> getResult(Map<String,Object> inMap) throws Exception {
		try {
			Map<String, Object> execute = sproc.execute(inMap);
			return execute;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

}
