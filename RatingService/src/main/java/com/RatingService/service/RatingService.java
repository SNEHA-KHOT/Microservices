package com.RatingService.service;

import com.RatingService.model.Rating;

public interface RatingService {

	Object createRating(Rating rating);

	Object getAll();

	Object getUserRating(long userId);

	Object getHotelRatings(long hotelId);

}
