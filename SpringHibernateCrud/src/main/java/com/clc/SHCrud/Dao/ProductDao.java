package com.clc.SHCrud.Dao;

import java.util.List;

import com.clc.SHCrud.Entity.ProductEntity;

public interface ProductDao {

	public boolean addProduct(ProductEntity proEntity);
	public boolean deleteProduct(int id);
	public ProductEntity getProduct(int id);
	public List<ProductEntity> getAllProduct();
	public boolean updateProduct(ProductEntity proEntity);
}
