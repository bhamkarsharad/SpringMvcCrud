package com.clc.CircularBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCircularBean {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("circularBean.xml");
		Emp emp = (Emp) context.getBean("ebean");
		Address address = (Address) context.getBean("adbean");

		System.out.println(emp.hashCode());
		System.out.println(address.hashCode());
	}

}

class Emp {

	Address address;

	
	static {
		System.out.println("emp class");
	}
	

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Address address) {
		super();
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

class Address {

	Emp emp;

	static {
		System.out.println("address class");
	}
	
	
	

	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Emp emp) {
		super();
		this.emp = emp;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}