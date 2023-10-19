package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.repositrory.UserRepository;



@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;

		
	@GetMapping("/user")
	public ResponseEntity<Object> getUser() {
		
		try {
			
			List<User> users = userRepository.findAll();
			
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@RequestBody User body) {
		
		try {
			User user = userRepository.save(body);
			
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<Object> getUserDetail(@PathVariable Integer userId ) {
		
		try {
			
			Optional<User> user = userRepository.findById(userId);
			if(user.isPresent()) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<Object> updateUser(@PathVariable Integer userId,@RequestBody User body) {
		
		try {
			Optional<User> user = userRepository.findById(userId);
			
			if(user.isPresent()) {
				User userEdit = user.get();
				userEdit.setFullname(body.getFullname());
				userEdit.setPassword(body.getPassword());
				userEdit.setEmail(body.getEmail());
				userEdit.setUserId(body.getUserId());
				
				userRepository.save(userEdit);
				
				return new ResponseEntity<>("EDIT SUCCESS", HttpStatus.OK);
			}else {
				
				return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<Object> deleteUser (@PathVariable Integer userId) {
		
		try {
			Optional<User> user = userRepository.findById(userId);
			if(user.isPresent()) {
				
				userRepository.delete(user.get());
				
				return new ResponseEntity<>("DELETE SUCCESS", HttpStatus.OK);
			}else {
				return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
