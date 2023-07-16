package com.UserService.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.UserService.model.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("/micro-hotel-services/v1/hotel/{hotelId}")
	Hotel getHotel(@PathVariable long hotelId ) ;
		
	

}
