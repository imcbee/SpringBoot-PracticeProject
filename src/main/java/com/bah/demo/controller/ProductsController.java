package com.bah.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.demo.domain.Products;
import com.bah.demo.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    ProductsService productsService;

    @GetMapping
    public List<Products> getAll() {
        return productsService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getById(@PathVariable String id) {
        Products product = productsService.getById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Products> createProduct (@RequestBody Products product, UriComponentsBuilder uri) {
        product = productsService.createProduct(product);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(product.getId())
            .toUri();
        
        ResponseEntity<Products> response = ResponseEntity.created(location).build();
        
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct (@RequestBody Products product, @PathVariable("id") String id) {
        product = productsService.updateProduct(product);
        
        //! not sure what to add here
            //? where will the logic for checking the user will go

        return null;
    }
}
