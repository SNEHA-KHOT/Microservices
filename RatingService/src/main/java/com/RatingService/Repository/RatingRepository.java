package com.RatingService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RatingService.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {

	List<Rating> findByuserId(long userId);

	List<Rating> findByhotelId(long hotelId);

}
