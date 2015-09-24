package com.mkyong.common;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.customer.dao.CustomerDAOI;
import com.mkyong.customer.model.Customer;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
   	 
    	
        CustomerDAOI customerDAO = (CustomerDAOI) context.getBean("customerDAO");
        Customer customer = new Customer(null, "mkyong",28);
        customerDAO.insert(customer);
    	
        Customer customer1 = customerDAO.findByCustomerId(1);
        assertNotNull(customer1);
        
    }
}
