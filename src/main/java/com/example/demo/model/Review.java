package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="review")
public class Review {

	@Id
	private Integer reviewId;
	private String userName;
	private String comment;
	
	
	
	public Integer getId() {
		return reviewId;
	}
	public void setId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
}
