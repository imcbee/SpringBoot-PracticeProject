package com.bah.demo.domain;
    
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Document(collection = "users")
public class Users {

    @Id
    private String id;

    private String username;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String password;

    private LocalDate registrationDate;

    @Nullable
    private List<Products> products;
}

