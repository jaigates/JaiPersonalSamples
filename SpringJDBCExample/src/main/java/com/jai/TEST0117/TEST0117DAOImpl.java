package com.jai.TEST0117;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TEST0117DAOImpl implements TEST0117DAO {

	private JdbcTemplate jdbcTemplate;
	private Test0117SP sproc;

	public void setDataSource(DataSource source) {
		this.jdbcTemplate = new JdbcTemplate(source);
		this.sproc = new Test0117SP(jdbcTemplate.getDataSource());
	}

	public Map<String, Object> getResult(String guid) {
		Map<String, Object> execute = sproc.execute(guid);
		return execute;
	}

}
