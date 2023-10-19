package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="product")
public class Product {
 
	@Id
	private Integer productId;
	private String nameProduct;
	private String detailProduct;
	private String review;
	
	
	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	/*@OneToMany(mappedBy = "product")
	private List<Review> reviews;*/
	
	
	public Product() {
		super();
	}


	public Product(Integer productId, String nameProduct, String priceProduct, String amountProduct,
			String detailProduct) {
		super();
		this.productId = productId;
		this.nameProduct = nameProduct;
		this.detailProduct = detailProduct;
	}


	/*public Product(List<Review> reviews) {
		super();
		this.reviews = reviews;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}*/


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getNameProduct() {
		return nameProduct;
	}


	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}


	public String getDetailProduct() {
		return detailProduct;
	}


	public void setDetailProduct(String detailProduct) {
		this.detailProduct = detailProduct;
	}
	
	
	
	
}
