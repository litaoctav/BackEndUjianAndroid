package com.ujianandroid.service;

import java.util.List;

import com.ujianandroid.entity.Product;


public interface ModelProductInterface {
	
	public List<Product> getAllProduct();
	public String addProduct(Product product);
	public String updateProduct(Product product);
	public Product getProductById (String id);
	public String deleteProduct(String id);

}
