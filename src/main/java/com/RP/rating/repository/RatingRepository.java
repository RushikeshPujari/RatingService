package com.RP.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RP.rating.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
	
	//Custom finder methods
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);

}
