package com.TEST0117;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_TEST0117 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		TEST0117DAO dao1 = (TEST0117DAO) context.getBean("TEST0117DAO");
		Map<String, Object> result = dao1.getResult("ABO01011");
		System.out.println(result);

	}
}
