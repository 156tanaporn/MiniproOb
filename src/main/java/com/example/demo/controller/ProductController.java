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
import com.example.demo.repositrory.ProductRepository;
import com.example.demo.model.Product;



@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

		
	@GetMapping("/product")
	public ResponseEntity<Object> getProduct() {
		
		try {
			
			List<Product> products = productRepository.findAll();
			return new ResponseEntity<>(products, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/product")
	public ResponseEntity<Object> addProduct(@RequestBody Product body) {
		
		try {
			Product product = productRepository.save(body);
			
			return new ResponseEntity<>(product, HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<Object> getProductDetail(@PathVariable Integer productId ) {
		
		try {
			
			Optional<Product> product = productRepository.findById(productId);
			if(product.isPresent()) {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Product Not Found", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<Object> updateProduct(@PathVariable Integer productId,@RequestBody Product body) {
		
		try {
			Optional<Product> product = productRepository.findById(productId);
			
			if(product.isPresent()) {
				Product productEdit = product.get();
				productEdit.setNameProduct(body.getNameProduct());
				productEdit.setDetailProduct(body.getDetailProduct());
				
				productRepository.save(productEdit);
				
				return new ResponseEntity<>("EDIT SUCCESS", HttpStatus.OK);
			}else {
				
				return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Object> deleteProduct (@PathVariable Integer productId) {
		
		try {
			Optional<Product> product = productRepository.findById(productId);
			if(product.isPresent()) {
				
				productRepository.delete(product.get());
				
				return new ResponseEntity<>("DELETE SUCCESS", HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Product Not Found", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
	
}
