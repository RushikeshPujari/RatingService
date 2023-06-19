package com.RP.rating.service;

import java.util.List;

import com.RP.rating.entities.Rating;

public interface RatingService {
	//create
	Rating create(Rating rating);
	
	//get all rating
	List<Rating> getRatings();
	
	//get all by UserId
	List<Rating> getRatingsByUserId(String UserId);
 	
	//get all by hotel
	List<Rating> getratingsByHotelId(String hotelId);
}
