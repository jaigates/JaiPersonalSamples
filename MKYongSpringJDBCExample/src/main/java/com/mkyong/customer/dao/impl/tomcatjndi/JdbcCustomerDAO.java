package com.mkyong.customer.dao.impl.tomcatjndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mkyong.customer.dao.CustomerDAOI;
import com.mkyong.customer.model.Customer;

public class JdbcCustomerDAO implements CustomerDAOI
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Customer customer){
		
		String sql = "INSERT INTO CUSTOMER " +
				"( NAME, AGE) VALUES ( ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getName());
			ps.setInt(2, customer.getAge());
			ps.executeUpdate();
			ps.close();
			conn.commit();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	
	public Customer findByCustomerId(int custId){
		
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(
						rs.getInt("CUST_ID"),
						rs.getString("NAME"), 
						rs.getInt("Age")
				);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} /*finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}*/
	}
	
	

public Customer findByCustomerName(String  custName){
		
		String sql = "SELECT * FROM CUSTOMER WHERE NAME = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, custName);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(
						rs.getInt("CUST_ID"),
						rs.getString("NAME"), 
						rs.getInt("Age")
				);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}/* finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}*/
	}
}




