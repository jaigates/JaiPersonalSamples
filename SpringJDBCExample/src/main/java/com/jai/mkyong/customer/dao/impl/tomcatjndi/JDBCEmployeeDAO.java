package com.jai.mkyong.customer.dao.impl.tomcatjndi;
import java.util.List;

import com.jai.mkyong.customer.dao.impl.Employee;

public interface JDBCEmployeeDAO {

	public void insert(Employee employee);
	public Employee findById(int id);
	public List<Employee> findAll();
}