package com.bah.demo.dto;

import java.util.Date;
import java.util.List;

import com.bah.demo.domain.Reviews;
import com.bah.demo.domain.Users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductsDto {
    private String id;
    private String productName;
    private String productDescription;
    private String productCategory;
    private Date dateOfCreation;
    private Boolean available;
    private Double price;
    private Integer rating;
    private String pictureURL;
    private Users user;
    private List<Reviews> productReviews;
}
