package com.ujianandroid.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujianandroid.entity.Product;
import com.ujianandroid.entity.Response;
import com.ujianandroid.service.ModelProduct;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ModelProduct modelProduct;
	
	@GetMapping("/")
	public ResponseEntity<Response> getAll(){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil mendapatkan data");
		
		response.setData(this.modelProduct.getAllProduct());

		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	@PostMapping("/add")
	public ResponseEntity<Response> addData(@RequestBody Product product){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil masukan data");
		
		response.setData(this.modelProduct.addProduct(product));

		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateData(@RequestBody Product product, @PathVariable String id){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil update data");
		
		product.setId(Long.parseLong(id));
		response.setData(this.modelProduct.updateProduct(product));

		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deletedData(@PathVariable String id){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil delete data");
		
		response.setData(this.modelProduct.deleteProduct(id));

		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Response> getProductById(@PathVariable String id){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil mendapatkan data berdasarkan id");
		
		response.setData(this.modelProduct.getProductById(id));

		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	
	
		
	}
}
