package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("myApp.xml");
		PropertyUtil myProperties = (PropertyUtil) ctx.getBean("propertyUtil");
		while (true) {
			System.out.println(myProperties.getProperty("myApp.propertyOne"));
			Thread.sleep(1000);
		}
	}
}