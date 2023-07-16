package com.HotelService.service;

import java.util.List;

import com.HotelService.entity.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	List<Hotel> getAll();
	Hotel get(long id);
	

}
