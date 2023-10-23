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
import com.example.demo.repositrory.SeriesRepository;
import com.example.demo.model.Series;



@RestController
public class SeriesController {

	@Autowired
	SeriesRepository seriesRepository;

		
	@GetMapping("/series")
	public ResponseEntity<Object> getSeries() {
		
		try {
			
			List<Series> series = seriesRepository.findAll();
			return new ResponseEntity<>(series, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/series")
	public ResponseEntity<Object> addSeries(@RequestBody Series body) {
		
		try {
			Series series = seriesRepository.save(body);
			
			return new ResponseEntity<>(series, HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/series/{seriesId}")
	public ResponseEntity<Object> getSeriesDetail(@PathVariable Integer seriesId ) {
		
		try {
			
			Optional<Series> series = seriesRepository.findById(seriesId);
			if(series.isPresent()) {
				return new ResponseEntity<>(series, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Series Not Found", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/seires/{seriesId}")
	public ResponseEntity<Object> updateSeries(@PathVariable Integer seriesId,@RequestBody Series body) {
		
		try {
			Optional<Series> series = seriesRepository.findById(seriesId);
			
			if(series.isPresent()) {
				Series seriesEdit = series.get();
				seriesEdit.setSeriesName(body.getSeriesName());
				seriesEdit.setDetailSeries(body.getDetailSeries());
				
				seriesRepository.save(seriesEdit);
				
				return new ResponseEntity<>("EDIT SUCCESS", HttpStatus.OK);
			}else {
				
				return new ResponseEntity<>("Series Not Found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/series/{seriesId}")
	public ResponseEntity<Object> deleteSeries (@PathVariable Integer seriesId) {
		
		try {
			Optional<Series> series = seriesRepository.findById(seriesId);
			if(series.isPresent()) {
				
				seriesRepository.delete(series.get());
				
				return new ResponseEntity<>("DELETE SUCCESS", HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Series Not Found", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
	
}