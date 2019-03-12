package com.clc.CircularBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	
	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("circularBean.xml");
		A a = (A) context.getBean("abean");
		B b = (B) context.getBean("bbean");
		
		B ba = a.b;
		A ab = b.a;
		
		System.out.println(a.hashCode() +" : " +ab.hashCode());
		System.out.println(b.hashCode() +" : " + ba.hashCode());
	}	
}

class A{
	B b;

	
	
	
	public A(B b) {
		super();
		this.b = b;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
	
	
	
}

class B{
	A a;

	
	public B(A a) {
		super();
		this.a = a;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}
	
	
}

