package com.bah.demo.domain;

import java.time.LocalDate;
import java.util.List;

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
