package com.clc.SHCrud.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clc.SHCrud.Beans.ProductBeans;
import com.clc.SHCrud.Dao.Impl.ProductDaoImpl;
import com.clc.SHCrud.Entity.ProductEntity;
import com.clc.SHCrud.Service.ProductService;

@Service("service")
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductDaoImpl productDao;
	
	
	public ProductServiceImpl() {
		super();
		System.out.println("service impl constructor");
	}
	public void setProductDao(ProductDaoImpl productDao) {
		this.productDao = productDao;
	}

public List<ProductBeans> convertEntitiesToBeans(List<ProductEntity> entities){
	List<ProductBeans> beans=new ArrayList<>();
	for (ProductEntity entity : entities) {
		beans.add(convertEntityToBean(entity));
	}
	return beans;
}

public ProductEntity convertBeanToEntity(ProductBeans bean) {
	return new ProductEntity(bean.getId(),bean.getName(),bean.getPrice(),bean.getCategory(),bean.getVendor());	
}

public ProductBeans convertEntityToBean(ProductEntity entity) {
	return new ProductBeans(entity.getId(),entity.getName(),entity.getPrice(),entity.getCategory(),entity.getVendor());
	
}
	@Override
	public boolean addProduct(ProductBeans proBean) {
		
		return productDao.addProduct(convertBeanToEntity(proBean));
	}

	@Override
	public boolean deleteProduct(int id) {
		
		return productDao.deleteProduct(id);
	}

	@Override
	public ProductBeans getProduct(int id) {
	
		return convertEntityToBean(productDao.getProduct(id));
	}

	@Override
	public List<ProductBeans> getAllProduct() {
		
		return convertEntitiesToBeans(productDao.getAllProduct());
	}

	@Override
	public boolean updateProduct(ProductBeans proBean) {

		return productDao.updateProduct(convertBeanToEntity(proBean));
	}

}
