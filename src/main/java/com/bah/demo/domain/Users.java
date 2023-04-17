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
<<<<<<< HEAD
@Document("users")
public class Users {

    public Users(String string, String string2, String string3, LocalDate of, String string4, LocalDate of2,
			Object object) {
		// TODO Auto-generated constructor stub
	}

	private String username;
=======
@Document(collection = "users")
public class Users {

    @Id
    private String id;

    private String username;
>>>>>>> 5bd7af941fbffb5349b4666b15f90d0ce49a1e98

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth; // necessary?

    private String password; // necessary?

    private LocalDate registrationDate; // necessary?

    @Nullable
    private List<Products> products;

}

