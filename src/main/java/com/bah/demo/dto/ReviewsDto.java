package com.bah.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ReviewsDto {
	private String id;
	
	private String userName;
	
	private Date reviewDate;
	
	private String productCode;
	
	private String title;
	
	private String productDescription;
	
	private String userReview;
	
}
