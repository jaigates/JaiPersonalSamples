package com.mkyong.customer.dao.impl.tomcatjndi;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.customer.dao.impl.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	int idi =new Random(99).nextInt();
    	 
    	JDBCEmployeeDAO jdao = (JDBCEmployeeDAO) context.getBean("jDBCEmployeeDAO");
    	Employee emp = new Employee();
		jdao.insert(emp);

        
    }
}
