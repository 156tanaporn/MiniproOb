package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Review;
import com.example.demo.repositrory.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewController {


    @Autowired
    ReviewRepository reviewRepository;
    
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/review")
	public ResponseEntity<Object> getReview() {
		
		try {
			
			List<Review> reviews = reviewRepository.findAll();
			return new ResponseEntity<>(reviews, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @GetMapping("/review/{reviewId}")
	public ResponseEntity<Object> getProductDetail(@PathVariable Integer reviewId ) {
		
		try {
			
			Optional<Review> review = reviewRepository.findById(reviewId);
			if(review.isPresent()) {
				return new ResponseEntity<>(review, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Product Not Found", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
    
    @PutMapping("/review/{reviewId}")
	public ResponseEntity<Object> updateProduct(@PathVariable Integer reviewId,@RequestBody Review body) {
		
		try {
			Optional<Review> review = reviewRepository.findById(reviewId);
			
			if(review.isPresent()) {
				Review reviewEdit = review.get();
				reviewEdit.setComment(body.getComment());
				
			
				reviewRepository.save(reviewEdit);
				
				return new ResponseEntity<>("EDIT SUCCESS", HttpStatus.OK);
			}else {
				
				return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PostMapping("/review")
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Integer reviewId, Review review) {
        if (reviewRepository.existsById(reviewId)) {
            review.setId(reviewId);
            return reviewRepository.save(review);
        }
        return null;
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
