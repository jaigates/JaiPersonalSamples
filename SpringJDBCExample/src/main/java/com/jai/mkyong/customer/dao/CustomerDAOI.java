package com.jai.mkyong.customer.dao;

import com.jai.mkyong.customer.model.Customer;

public interface CustomerDAOI 
{
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public Customer findByCustomerName(String name);
	
	
	
}




