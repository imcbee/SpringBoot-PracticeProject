package com.bah.demo.service;

import java.util.List;

import com.bah.demo.domain.Products;

public interface ProductsService {
    public List<Products> getAll();

    public Products getById(String id);
    
    public Products createProduct(Products product);

    public Products updateProduct(Products product);
}
