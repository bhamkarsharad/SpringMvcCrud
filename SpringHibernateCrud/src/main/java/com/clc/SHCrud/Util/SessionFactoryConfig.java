package com.clc.SHCrud.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


public class SessionFactoryConfig {

	@Autowired
	static SessionFactory sessionFactory;

static	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public  void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public static void cleanupResource(Session session,Transaction tr) {
		if(session!=null) {
			if(tr!=null) {
				session.flush();
				tr.commit();
			}
			session.close();
		}
		
	} 
	
}
