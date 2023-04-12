package com.bah.demo.domain;
    
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

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
@Document("users")
public class Users {

    public Users(String string, String string2, String string3, LocalDate of, String string4, LocalDate of2,
			Object object) {
		// TODO Auto-generated constructor stub
	}

	private String username;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth; // necessary?

    private String password; // necessary?

    private LocalDate registrationDate; // necessary?

    private List<Products> products;

}

