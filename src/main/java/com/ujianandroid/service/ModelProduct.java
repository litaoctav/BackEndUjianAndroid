package com.ujianandroid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujianandroid.entity.Product;
import com.ujianandroid.repository.ProductRepository;

@Service
public class ModelProduct implements ModelProductInterface {
	
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return this.productRepo.findAll();
	}

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		this.productRepo.save(product);
		return "Berhasil menambahkan data";
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		this.productRepo.save(product);
		return "Berhasil mengubah data";
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return this.productRepo.findById(Long.parseLong(id)).get();
	}

	@Override
	public String deleteProduct(String id) {
		// TODO Auto-generated method stub
		this.productRepo.deleteById(Long.parseLong(id));
		return "Berhasil menghapus data";

	}

}
