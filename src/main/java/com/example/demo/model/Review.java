package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reviewId;
	private String comment;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "series_id")
	private Series series;
	
	
	public Review() {
		super();
	}
	
	public Review(Integer reviewId, String comment, User user) {
		super();
		this.reviewId = reviewId;
		this.comment = comment;
	}
	public Review(User user, Series series) {
		super();
		this.user = user;
		this.series = series;
	}

	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}

	public Integer getId() {
		return reviewId;
	}
	public void setId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
}
