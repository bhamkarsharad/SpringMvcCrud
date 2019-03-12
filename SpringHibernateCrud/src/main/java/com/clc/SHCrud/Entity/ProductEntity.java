package com.clc.SHCrud.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product_info")
public class ProductEntity {
	
	@Id
	private int id;
	private String name;
	private double price;
	private String category;
	private String vendor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	@Override
	public String toString() {
		return "\n ProductEntity [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", vendor=" + vendor + "]";
	}
	public ProductEntity(int id, String name, double price, String category, String vendor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.vendor = vendor;
	}
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
