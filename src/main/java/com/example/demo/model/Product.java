package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="product")
public class Product {
 
	@Id
	private Integer productId;
	private String nameProduct;
	private String detailProduct;
	
	
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
