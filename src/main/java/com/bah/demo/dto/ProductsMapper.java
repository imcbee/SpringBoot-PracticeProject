package com.bah.demo.dto;

import org.springframework.stereotype.Component;

import com.bah.demo.domain.Products;

@Component
public class ProductsMapper {

    public ProductsDto toDto(Products product) {

        return new ProductsDto(product.getId(), product.getProductName(), product.getProductDescription(), product.getProductCategory(), product.getDateOfCreation(), product.getAvailable(), product.getPrice(), product.getRating(), product.getPictureURL(), product.getUser(), product.getProductReviews());
    }

    public Products fromDto(ProductsDto productsDto) {
        return new Products(productsDto.getId(), productsDto.getProductName(), productsDto.getProductDescription(), productsDto.getProductCategory(), productsDto.getDateOfCreation(), productsDto.getAvailable(), productsDto.getPrice(), productsDto.getRating(), productsDto.getPictureURL(), productsDto.getUser(), productsDto.getProductReviews());
    }
}
