package com.mkyong.customer.model;


public class Customer 
{
	Integer custId;
	String name;
	Integer age;
	
	
	public Customer(Integer custId, String name, Integer age) {
		this.custId = custId;
		this.name = name;
		this.age = age;
	}
	
	public Customer(String string, int i) {
		this.name = string;
		this.age = i;
	}

	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [age=" + age + ", custId=" + custId + ", name=" + name
				+ "]";
	}
	
	
}
