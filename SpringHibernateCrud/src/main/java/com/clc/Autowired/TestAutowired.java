package com.clc.Autowired;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowired {
public static void main(String[] args) {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("AutowiredBean.xml");
	
	Book b1=new Book(1,"AAA", 1234.23);
	Book b2=new Book(2,"BBB", 4334.23);
	
	MysessionFactory mysessionFactory= (MysessionFactory) context.getBean("stutil");
	System.out.println(mysessionFactory.sessionFactory);
	System.out.println(mysessionFactory.sessionFactory.hashCode());

	SessionFactory sessionFactory1=(SessionFactory) context.getBean("sfactory1");
	SessionFactory sessionFactory2=(SessionFactory) context.getBean("sfactory2");

	System.out.println(sessionFactory1);
	System.out.println(sessionFactory2);
	System.out.println(sessionFactory1==sessionFactory2);
	System.out.println(mysessionFactory.sessionFactory.hashCode());
	
  /*  SessionFactory sessionFactory=(SessionFactory) context.getBean("sfactory1");
	
	Session session= sessionFactory.openSession();
	Transaction tr= session.beginTransaction();
	session.save(b1);
	session.save(b2);
	session.flush();
	tr.commit();
	session.close();
	*/
}
}



