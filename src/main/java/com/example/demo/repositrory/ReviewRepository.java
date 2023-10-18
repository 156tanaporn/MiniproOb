package com.example.demo.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
