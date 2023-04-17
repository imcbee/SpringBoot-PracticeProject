package com.bah.demo.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewsDto {
	private long id;
	
	private String userName;
	
	private Date reviewDate;
	
	private String productCode;
	
	private String title;
	
	private String productDescription;
	
	private String userReview;
}
