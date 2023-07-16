package com.HotelService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.HotelService.entity.Hotel;
import com.HotelService.service.HotelService;

@Controller
public class HotelServiceController {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping("v1/hotel/create")
	public Object createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
		
	}

	@GetMapping("v1/hotels")
	public Object getHotels() {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
		
	}
	
	@GetMapping("v1/hotel/{hotelId}")
	public Object getHotel(@PathVariable ("hotelId") long hotelId) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
		
	}
}
