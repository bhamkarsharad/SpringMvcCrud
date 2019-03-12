package com.clc.Autowired;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("stutil")
public class MysessionFactory {
	
	@Autowired
	@Qualifier("sfactory1")
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MysessionFactory() {
		super();
		System.out.println("mysessionfactory object created ");
	}
	
	

}
