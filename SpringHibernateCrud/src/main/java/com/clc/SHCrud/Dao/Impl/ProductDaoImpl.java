package com.clc.SHCrud.Dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clc.SHCrud.Dao.ProductDao;
import com.clc.SHCrud.Entity.ProductEntity;
import com.clc.SHCrud.Util.SessionFactoryConfig;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	public SessionFactory sessionFactory=null;
	
	
	public ProductDaoImpl() {
		super();
		System.out.println("productDaoimppl constructor");
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addProduct(ProductEntity proEntity) {
		int id=0;
		Session session =null;
		Transaction tr=null;
		try {
			
			session = sessionFactory.openSession();
		    tr=	session.beginTransaction();
		  id=  (int) session.save(proEntity);
			
		} catch (Exception e) {
			System.out.println("problem in add method"+e.getMessage());
		}finally {
			SessionFactoryConfig.cleanupResource(session, tr);
		}
		return id>0;
	}

	@Override
	public boolean deleteProduct(int id) {
		
		Session session =null;
		Transaction tr=null;
		ProductEntity entity = getProduct(id);
		if(entity!=null) {
		try {
			
			session = sessionFactory.openSession();
		    tr=	session.beginTransaction();
		     session.delete(entity);
			
		} catch (Exception e) {
			System.out.println("problem in delete method"+e.getMessage());
		}finally {
			SessionFactoryConfig.cleanupResource(session, tr);
		}
		}
		return true;
		
	}

	@Override
	public ProductEntity getProduct(int id) {

		Session session =null;
		session = sessionFactory.openSession();	  
		 ProductEntity pEntity=  session.get(ProductEntity.class, id);
		 SessionFactoryConfig.cleanupResource(session, null);
		return pEntity;
	}

	@Override
	public List<ProductEntity> getAllProduct() {

		Session session =null;
		session = sessionFactory.openSession();	  
		List< ProductEntity> plEntity=  session.createCriteria(ProductEntity.class).list();
		 SessionFactoryConfig.cleanupResource(session, null);
		return plEntity;	
	}

	@Override
	public boolean updateProduct(ProductEntity proEntity) {
		
		Session session =null;
		Transaction tr=null;
		ProductEntity entity=null;
		try {
			
			session = sessionFactory.openSession();
		    tr=	session.beginTransaction();
	       entity= (ProductEntity) session.merge(proEntity);
			
		} catch (Exception e) {
			System.out.println("problem in update method"+e.getMessage());
		}finally {
			SessionFactoryConfig.cleanupResource(session, tr);
		}
		return entity!=null;
	}

}
