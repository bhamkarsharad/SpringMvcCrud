package com.clc.SHCrud.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.clc.SHCrud.Beans.ProductBeans;
import com.clc.SHCrud.Configuration.SpringHibernateJavaConfig;
import com.clc.SHCrud.Service.Impl.ProductServiceImpl;

@Controller
public class ProductController {
	public static void main(String[] args) {
		
		//ApplicationContext context=new ClassPathXmlApplicationContext("CrudBean.xml");
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(SpringHibernateJavaConfig.class);
		ProductServiceImpl service= (ProductServiceImpl) context.getBean("service");
		System.out.println("ProductServiceImpl:"+service);
		System.out.println("DaoIMPL:"+service.productDao);
		System.out.println("sessionFactory:"+service.productDao.sessionFactory);
		ProductBeans p1=new ProductBeans(1, "mobile", 30000.0, "A+", "apple");
		ProductBeans p2=new ProductBeans(2, "lappt", 50000.0, "B+", "dell");
		ProductBeans p3=new ProductBeans(3, "tv", 20000.0, "C+", "lg");
		ProductBeans p4=new ProductBeans(4, "ac", 40000.0, "D+", "samsung");
		service.addProduct(p1);
		service.addProduct(p2);
		service.addProduct(p3);
		service.addProduct(p4);
		
		System.out.println(service.getAllProduct());
		System.out.println(service.deleteProduct(4));
		System.out.println(service.getProduct(2));
		System.out.println(service.getAllProduct());
		System.out.println(service.updateProduct(new ProductBeans(1, "mobile", 22222, "ab", "moto")));
		System.out.println(service.getAllProduct());


	}

}
