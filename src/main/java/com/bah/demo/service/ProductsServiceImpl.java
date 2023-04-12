package com.bah.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.demo.domain.Products;
import com.bah.demo.exception.ProductNotFoundException;
import com.bah.demo.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService{
    
    @Autowired
    ProductsRepository productsRepo;

    @Override
    public List<Products> getAll() {
        return productsRepo.findAll();
    };

    @Override
    public Products getById(String id){
        return productsRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    };
    
    @Override
    public Products createProduct(Products product){
        return productsRepo.save(product);
    };


}
