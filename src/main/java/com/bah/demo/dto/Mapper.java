package com.bah.demo.dto;

import org.springframework.stereotype.Component;

import com.bah.demo.domain.Users;

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

    public Users fromDto(UsersDto userDto) {

        return new Users(
            userDto.getId(),
            userDto.getUsername(),
            userDto.getFirstName(),
            userDto.getLastName(),
            userDto.getDateOfBirth(),
            null,
            null,
            userDto.getProducts()
        );
        
    }
    
}
