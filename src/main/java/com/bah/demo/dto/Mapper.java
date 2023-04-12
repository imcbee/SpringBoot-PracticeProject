package com.bah.demo.dto;

import org.springframework.stereotype.Component;

import com.bah.demo.domain.Users;
import com.bah.demo.domain.UsersDto;

@Component
public class Mapper {
    
    public UsersDto toDto(Users user) {

        return new UsersDto(
            user.getId(),
            user.getUsername(),
            user.getFirstName(),
            user.getLastName(),
            user.getDateOfBirth(),
            user.getProducts()
        );
        
    }
}