package com.bah.demo.exception;

public class ProductNotFoundException extends RuntimeException{
    
    public ProductNotFoundException(String id) {
        super("The Product id" + id + "does not exist");
    }
}
