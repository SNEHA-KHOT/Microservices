package com.RatingService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.RatingService.model.Rating;
import com.RatingService.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@PostMapping("v1/ratings/create")
	public Object createrating(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
		
	}

	@GetMapping("v1/ratings")
	public Object getHotels() {
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAll());
		
	}
	@GetMapping("v1/rating/user/{userId}")
	public Object getUserRating(@PathVariable ("userId") long userId) {
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getUserRating(userId));
		
	}
	@GetMapping("v1/rating/hotel/{hotelId}")
	public Object getHotelRatings(@PathVariable ("hotelId") long hotelId) {
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getHotelRatings(hotelId));
		
	}
	
}
	
	
	
	
	
	
	
	
	
	

