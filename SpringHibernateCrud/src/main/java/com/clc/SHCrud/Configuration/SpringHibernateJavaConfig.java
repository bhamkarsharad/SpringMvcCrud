package com.clc.SHCrud.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan({"com.clc.SHCrud.*"})
@PropertySource(value= {"classpath:database.properties"})
public class SpringHibernateJavaConfig {

	@Value("${jdbc.driverClassName}")String driverClassName;
	@Value("${jdbc.url}")String dbUrl;
	@Value("${jdbc.username}")String dbUserName;
	@Value("${jdbc.password}")String Password;
	@Value("${hibernate.dialect}")String hbmDialectPropertyValue;
	@Value("${hibernate.show_sql}")String hbmShowSqlPropertyValue;
	@Value("${hibernate.format_sql}")String hbmFormatSqlPropertyValue;
	@Value("${hibernate.hbmddl}")String hbmDdlAutoPropertyValue;
	
	String hbmDialictProperty="hibernate.dialect";
	String hbmShowSqlProperty="hibernate.show_sql";
	String FormatSqlProperty="hibernate.format_sql";
	String DdlAutoProperty="hibernate.hbm2ddl.auto";

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println(hbmDialectPropertyValue);
		System.out.println(hbmDialictProperty);
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.clc.*"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
		
	}
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(Password);
		return dataSource;
	}
	
	private Properties hibernateProperties() {
		Properties prop=new Properties();
		prop.put(hbmDialictProperty, hbmDialectPropertyValue);
		prop.put(hbmShowSqlProperty, hbmShowSqlPropertyValue);
		prop.put(FormatSqlProperty, hbmFormatSqlPropertyValue);
		prop.put(DdlAutoProperty, hbmDdlAutoPropertyValue);
		
		return prop;
		
	}




	
	
	
	
}
