package domain;
    

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private String username;

    private String firstName;

    private String lastName;

    private Instant dateOfBirth; // necessary?

    private String password; // necessary?

    private Instant registrationDate; // necessary?

    private List<Products> products;

}

