package com.RatingService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RatingService.Repository.RatingRepository;
import com.RatingService.model.Rating;
import com.RatingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepo;
	
	@Override
	public Object createRating(Rating rating) {
		
		return ratingRepo.save(rating);
	}

	@Override
	public Object getAll() {
	
		return ratingRepo.findAll();
	}

	@Override
	public Object getUserRating(long userId) {
		
		return ratingRepo.findByuserId(userId);
	}

	@Override
	public Object getHotelRatings(long hotelId) {
		
		return ratingRepo.findByhotelId(hotelId);
	}

}
