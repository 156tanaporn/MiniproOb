package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="series")
public class Series {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seriesId;
	private String seriesName;
	private String detailSeries;
	private String review;
	
	
	public Series(Integer seriesId, String seriesName, String detailSeries, String review) {
		super();
		this.seriesId = seriesId;
		this.seriesName = seriesName;
		this.detailSeries = detailSeries;
		this.review = review;
	}


	public Series() {
		super();
	}


	public Integer getSeriesId() {
		return seriesId;
	}


	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}


	public String getSeriesName() {
		return seriesName;
	}


	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}


	public String getDetailSeries() {
		return detailSeries;
	}


	public void setDetailSeries(String detailSeries) {
		this.detailSeries = detailSeries;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}
	
	
	
	
	
	
	
	
	
}
