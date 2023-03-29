package domain;

import domain.Products;

import java.time.Instant;
import java.util.List;

public class User {

    private String username;

    private String firstName;

    private String lastName;

    private Instant dateOfBirth; // necessary?

    private String password; // necessary?

    private Instant registrationDate; // necessary?

    private List<Products> products;

}