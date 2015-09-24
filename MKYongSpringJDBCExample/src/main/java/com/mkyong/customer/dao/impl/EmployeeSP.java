package com.mkyong.customer.dao.impl;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/*
 * Inner class to implement stored procedure in spring.
 */
public class EmployeeSP extends StoredProcedure {
	private static final String SPROC_NAME = "usp_GetEmployeeName";
	private static final String id = "id";
	private static final String name = "name";

	public EmployeeSP(DataSource datasource) {
		super(datasource, SPROC_NAME);

		declareParameter(new SqlParameter(id, Types.INTEGER)); // declaring
																// sql
																// in
																// parameter
																// to
																// pass
																// input

		declareParameter(new SqlOutParameter(name, Types.VARCHAR)); // declaring
																	// sql
																	// out
																	// parameter
		compile();
	}

	public Object execute(int emp_id) {
		Map<String, Object> results = super.execute(emp_id);
		return results.get(name); // reading output of stored procedure
									// using out parameters

	}
}