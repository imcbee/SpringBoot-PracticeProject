package com.bah.demo.domain;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
@Document(collection = "products")
public class Products {

    // variables
    @Id
    private String id;

    private String productName;
    private String productDescription;
    private String productCategory;
    private Date dateOfCreation;
    private Boolean available;
    private Double price;
    private Integer rating;
    private String pictureURL;

    @DBRef
    Users user;

    @DBRef
    private List<Reviews> productReviews;

   

}
