package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Review;
import com.example.demo.model.Product;
import com.example.demo.repositrory.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewController {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Integer reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public Optional<Review> getReviewsByProduct(Integer productId) {
        return reviewRepository.findById(productId);
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
        return null; // Review with the given ID doesn't exist
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
