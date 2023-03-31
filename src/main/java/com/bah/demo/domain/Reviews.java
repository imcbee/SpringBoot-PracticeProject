package com.bah.demo.domain;

import java.util.Date;
import java.util.Objects;

// @Document(collection = "review")
public class Reviews {
	
	// @Id
	private long id;
	
	private String userName;
	
	private Date reviewDate;
	
	private String productCode;
	
	private String title;
	
	private String productDescription;
	
	private String userReview;

	public Reviews(long id, String userName, Date reviewDate, String productCode, String title,
			String productDescription, String userReview) {
		super();
		this.id = id;
		this.userName = userName;
		this.reviewDate = reviewDate;
		this.productCode = productCode;
		this.title = title;
		this.productDescription = productDescription;
		this.userReview = userReview;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getUserReview() {
		return userReview;
	}

	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", userName=" + userName + ", reviewDate=" + reviewDate + ", productCode="
				+ productCode + ", title=" + title + ", productDescription=" + productDescription + ", userReview="
				+ userReview + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, productCode, productDescription, reviewDate, title, userName, userReview);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reviews other = (Reviews) obj;
		return id == other.id && Objects.equals(productCode, other.productCode)
				&& Objects.equals(productDescription, other.productDescription)
				&& Objects.equals(reviewDate, other.reviewDate) && Objects.equals(title, other.title)
				&& Objects.equals(userName, other.userName) && Objects.equals(userReview, other.userReview);
	}
	
}
