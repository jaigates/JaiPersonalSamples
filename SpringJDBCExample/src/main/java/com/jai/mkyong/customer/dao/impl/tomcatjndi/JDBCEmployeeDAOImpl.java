package com.jai.mkyong.customer.dao.impl.tomcatjndi;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jai.mkyong.customer.dao.impl.Employee;
import com.jai.mkyong.customer.dao.impl.EmployeeRowMapper;

public class JDBCEmployeeDAOImpl implements JDBCEmployeeDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Employee employee) {

		String sql = "INSERT INTO EMPLOYEE1 " + "(ID, NAME, AGE) VALUES (?, ?, ?)";

		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] { employee.getId(), employee.getName(), employee.getAge() });
	}

	@SuppressWarnings({ "unchecked" })
	public Employee findById(int id) {

		String sql = "SELECT * FROM EMPLOYEE1 WHERE ID = ?";

		jdbcTemplate = new JdbcTemplate(dataSource);
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[] { id }, new EmployeeRowMapper());

		return employee;
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}