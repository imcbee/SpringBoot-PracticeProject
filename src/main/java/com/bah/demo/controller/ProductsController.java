package com.bah.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.demo.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    ProductsService productsService;

    
}
