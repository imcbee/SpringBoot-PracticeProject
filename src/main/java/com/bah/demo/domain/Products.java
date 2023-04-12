package com.bah.demo.domain;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private List<Reviews> productReviews;

    // Default Constructor
    public Products() {

    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public List<Reviews> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(List<Reviews> productReviews) {
        this.productReviews = productReviews;
    }

    // toString
    @Override
    public String toString() {
        return "Products [id=" + id + ", productName=" + productName + ", productDescription=" + productDescription
                + ", productCategory=" + productCategory + ", dateOfCreation=" + dateOfCreation + ", available="
                + available + ", price=" + price + ", rating=" + rating + ", pictureURL=" + pictureURL
                + ", productReviews=" + productReviews + "]";
    }

}
