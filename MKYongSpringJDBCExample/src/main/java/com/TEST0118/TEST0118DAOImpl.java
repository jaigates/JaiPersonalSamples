package com.TEST0118;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TEST0118DAOImpl implements TEST0118DAO {

	private JdbcTemplate jdbcTemplate;

	private Test0118SP sproc;

	public void setDataSource(DataSource source) {
		this.jdbcTemplate = new JdbcTemplate(source);
		this.sproc = new Test0118SP(jdbcTemplate.getDataSource());
	}

	@Override
	public Map<String, Object> getResult(String IN_ACCT_ID, String IN_MICRODEBIT_FLAG, String IN_PLAID_FLAG, Integer IN_RETRY_CNT) {
		Map<String, Object> execute = sproc.execute(IN_ACCT_ID, IN_MICRODEBIT_FLAG, IN_PLAID_FLAG, IN_RETRY_CNT);
		return execute;
	}

}
