package com.bah.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bah.demo.domain.Products;

public interface ProductsRepository extends MongoRepository <Products, String> {

}
