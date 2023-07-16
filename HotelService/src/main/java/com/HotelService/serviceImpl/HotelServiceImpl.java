package com.HotelService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.Repository.HotelRepo;
import com.HotelService.entity.Hotel;
import com.HotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo hotelRepo;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(long id) {
		
		return hotelRepo.findById(id).get();
	}

}
