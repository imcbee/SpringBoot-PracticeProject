package com.bah.demo.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(String id) {
        super("The Review id '" + id + "' does not exist");
    }
}
