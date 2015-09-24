package com.mkyong.customer.dao;

import javax.sql.DataSource;

public interface EmployeeDAOI {

	public abstract void setDataSource(DataSource source);

	/*
	 * wraps stored procedure call
	 */
	public abstract String getEmployeeName(int emp_id);

}