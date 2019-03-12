package com.clc.SHCrud.Service;

import java.util.List;

import com.clc.SHCrud.Beans.ProductBeans;

public interface ProductService {
	
	public boolean addProduct(ProductBeans proBean);
	public boolean deleteProduct(int id);
	public ProductBeans getProduct(int id);
	public List<ProductBeans> getAllProduct();
	public boolean updateProduct(ProductBeans proBean);

}
