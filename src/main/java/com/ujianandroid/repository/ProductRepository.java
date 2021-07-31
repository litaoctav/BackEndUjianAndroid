package com.ujianandroid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujianandroid.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
