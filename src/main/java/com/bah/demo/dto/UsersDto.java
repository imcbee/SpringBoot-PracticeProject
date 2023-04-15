package com.bah.demo.dto;

import java.time.LocalDate;
import java.util.List;

import com.bah.demo.domain.Products;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersDto {

    private String id;

    private String username;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private List<Products> products;

}
