package com.UserService.externalService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.UserService.model.Rating;

//@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("/micro-rating-services/v1/rating/user/{userId}")
	Rating[] getUserRating(@PathVariable long userId);
	

	@PostMapping("/micro-rating-services/v1/ratings/create")
	ResponseEntity<Rating> createRating(@RequestBody Rating rating);

	/*@PutMapping("/micro-rating-services//rating/update")
	Rating updateRating(@RequestBody Rating rating);
	
	@DeleteMapping("/micro-rating-services/{ratingId}")
	void deleteRating(@PathVariable long ratingId);*/
}
