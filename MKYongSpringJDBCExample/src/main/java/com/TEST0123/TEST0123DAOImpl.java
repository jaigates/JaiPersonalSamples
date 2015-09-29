package com.TEST0123;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TEST0123DAOImpl implements TEST0123DAO {

	private JdbcTemplate jdbcTemplate;

	private Test0123SP sproc;

	public void setDataSource(DataSource source) {
		this.jdbcTemplate = new JdbcTemplate(source);
		this.sproc = new Test0123SP(jdbcTemplate.getDataSource());
	}

	@Override
	public Map<String, Object> getResult(String IN_GUID, String SQLCODE_PARM, String RESP_CODE, String RESP_MSG) {
		Map<String, Object> execute = sproc.execute(IN_GUID, SQLCODE_PARM, RESP_CODE, RESP_MSG);
		return execute;
	}

}
