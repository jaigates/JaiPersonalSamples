package com.mkyong.common;

import java.util.Map;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.TEST0117.TEST0117DAO;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	int idi =new Random(99).nextInt();
    	 
/*        CustomerDAOI customerDAO = (CustomerDAOI) context.getBean("customerDAO");
        String name = System.currentTimeMillis()+"";
		
		Customer customer = new Customer(name,1);
        customerDAO.insert(customer);
    	
        Customer customer1 = customerDAO.findByCustomerName(name);
        System.out.println(customer1);
        
        EmployeeDAOI dao = (EmployeeDAOI) context.getBean("employeeDao");

		// calling stored procedure using DAO method
		String employeeName = dao.getEmployeeName(customer1.getCustId());
		System.out.printf("Employee name for id %s is :%s",customer1.getCustId(), employeeName);*/
		
		
		 TEST0117DAO dao1 = (TEST0117DAO) context.getBean("copyOfEmployeeDao");
		 Map<String, Object> result = dao1.getResult("ABO01011");
		 System.out.println(result);
		 
		 
        
    }
}
