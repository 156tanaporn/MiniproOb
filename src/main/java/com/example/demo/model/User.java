package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String username;
	private String password;
	private String fullname;
	private String email;
	
	
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;
	
	
	public User(Integer id, String username, String password, String fullname, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
	}
	
	
	
	public User() {
		super();
	}


	public User(List<Review> reviews) {
		super();
		this.reviews = reviews;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
	
}
