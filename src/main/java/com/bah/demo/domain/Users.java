package com.bah.demo.domain;
    
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private String username;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth; // necessary?

    private String password; // necessary?

    private LocalDate registrationDate; // necessary?

    private List<Products> products;

}

