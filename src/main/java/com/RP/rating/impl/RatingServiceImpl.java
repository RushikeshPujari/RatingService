package com.RP.rating.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RP.rating.entities.Rating;
import com.RP.rating.repository.RatingRepository;
import com.RP.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating create(Rating rating) {
		String generatedID = UUID.randomUUID().toString();
		rating.setRatingId(generatedID);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getratingsByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
