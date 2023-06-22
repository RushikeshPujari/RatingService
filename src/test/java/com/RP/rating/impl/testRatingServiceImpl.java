package com.RP.rating.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.RP.rating.entities.Rating;
import com.RP.rating.repository.RatingRepository;

public class testRatingServiceImpl {

	RatingServiceImpl ratingServiceImpl = new RatingServiceImpl();
	
	RatingRepository  ratingRepository = Mockito.mock(RatingRepository.class);
	
	public List<Rating> createMockRatingData() {
		List<Rating> ratingList = new ArrayList<Rating>();
		Rating rating = new Rating();
		rating.setRatingId("1R");
		rating.setHotelId("101H");
		rating.setFeedback("Good Taste");
		rating.setUserId("1U");
		rating.setRating(8);
		
		ratingList.add(rating);
		return ratingList;
		
	}
	
	@Test
	void test_getAllRatings() {
		
		ReflectionTestUtils.setField(ratingServiceImpl, "ratingRepository", ratingRepository);
		List<Rating> ratingList = createMockRatingData();
		when(ratingRepository.findAll()).thenReturn(ratingList);
		
		List<Rating> response = ratingServiceImpl.getRatings();
		
		assertEquals(1, response.size());
	}


	@Test
	void test_create() {

		ReflectionTestUtils.setField(ratingServiceImpl, "ratingRepository", ratingRepository);
		List<Rating> ratingList = createMockRatingData();
		when(ratingRepository.save(ratingList.get(0))).thenReturn(ratingList.get(0));
		
		Rating response =ratingServiceImpl.create(ratingList.get(0));
		
		assertEquals("Good Taste", response.getFeedback());
	}
	
	@Test
	void test_getRatingByUserId() {
		ReflectionTestUtils.setField(ratingServiceImpl, "ratingRepository", ratingRepository);
		List<Rating> ratingList = createMockRatingData();
		when(ratingRepository.findByUserId(ratingList.get(0).getUserId())).thenReturn(ratingList);
		
		List<Rating> response = ratingServiceImpl.getRatingsByUserId(ratingList.get(0).getUserId());
		
		assertEquals(1, response.size());
	}
	
	@Test
	void test_getRatingByHotelId() {
		ReflectionTestUtils.setField(ratingServiceImpl, "ratingRepository", ratingRepository);
		List<Rating> ratingList = createMockRatingData();
		when(ratingRepository.findByHotelId(ratingList.get(0).getHotelId())).thenReturn(ratingList);
		
		List<Rating> response = ratingServiceImpl.getratingsByHotelId(ratingList.get(0).getHotelId());
		
		assertEquals(1, response.size());
	}
	
	
}
