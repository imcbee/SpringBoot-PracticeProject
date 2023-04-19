package com.bah.demo.dto;

import org.springframework.stereotype.Component;

import com.bah.demo.domain.Reviews;

@Component
public class ReviewsMapper {

    public ReviewsDto toDto(Reviews review) {

        return new ReviewsDto(
        	review.getId(),
        	review.getUserName(),
        	review.getReviewDate(),
        	review.getProductCode(),
        	review.getTitle(),
        	review.getProductDescription(),
        	review.getUserReview()
        );
        
    }
    
    public Reviews fromDto(ReviewsDto reviewDto) {
    	return new Reviews(
    		reviewDto.getId(),
    		reviewDto.getUserName(),
    		reviewDto.getReviewDate(),
    		reviewDto.getProductCode(),
    		reviewDto.getTitle(),
    		reviewDto.getProductDescription(),
    		reviewDto.getUserReview()
    	);
    			
    }

	
}
