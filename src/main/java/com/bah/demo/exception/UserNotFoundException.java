package com.bah.demo.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super("The User id '" + id + "' does not exist");
    }
    
}
