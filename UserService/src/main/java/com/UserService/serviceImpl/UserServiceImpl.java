package com.UserService.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.UserService.Dto.userReqDto;
import com.UserService.Dto.userResDto;
import com.UserService.externalService.HotelService;
import com.UserService.externalService.RatingService;
import com.UserService.model.Hotel;
import com.UserService.model.Rating;
import com.UserService.model.User;
import com.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private  com.UserService.Repository.UserRepo userRepo;

	@Autowired 
	private RestTemplate restTemplate;
	
	@Autowired 
	private HotelService hotelService;
	
	@Autowired 
	private RatingService ratingService;
	
	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public List<userResDto> getAllUsers() {
		List<User> users =userRepo.findAll();
		List<userResDto> userList = new ArrayList<userResDto>();
		for(User user1:users) {
			
			userResDto dto =DaoToDto(user1);
			userList.add(dto);
			
		}
		return userList;
	}
	
	public userResDto DaoToDto(User user) {
		userResDto userDto = new userResDto();
		userDto.setUserId(user.getUserId());
		userDto.setUserName(user.getUserName());
		userDto.setUserEmail(user.getUserEmail());
		userDto.setStatus(user.getStatus());
		userDto.setCreatedOn(user.getCreatedOn());
		userDto.setLastUpdatedOn(user.getLastUpdatedOn());
		userDto.setRatings(user.getRatings());
		return userDto;
	}

	

	@Override
	public userResDto getUser(long userId) {
		User user =userRepo.findById(userId)/*.orElseThrow(()->new ResourceNotFoundException("user not found "))*/;
		//fetch ratings from RATING-SERVICE
		//http://localhost:8080/v1/rating/user/1
		//Rating[] ratingOfUser = restTemplate.getForObject("http://localhost:8088/v1/rating/user/"+user.getUserId() ,Rating[].class);
		//Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/micro-rating-services/v1/rating/user/"+user.getUserId() ,Rating[].class);
		
		Rating[] ratingOfUser =ratingService.getUserRating(userId);
		log.info("{}",ratingOfUser);
		
		List<Rating> ratings =Arrays.stream(ratingOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating ->{
			
			//http://localhost:8083/v1/hotel/1
			/*ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/v1/hotel/"+rating.getUserId() , Hotel.class);
			Hotel hotel =forEntity.getBody();
			
			log.info("StatusCode",forEntity.getStatusCode());*/
			
			Hotel hotel =hotelService.getHotel(rating.getUserId());
			
		rating.setHotel(hotel);
			return rating;
			
		}).collect(Collectors.toList());
		
		
		user.setRatings(ratingList);
		userResDto dto =DaoToDto(user);
		dto.setRatings(ratingList);
		return dto;
	}

	@Override
	public Object deleteUser(long userId) {
		User user =userRepo.findById(userId);
		user.setStatus(0);
		userRepo.save(user);
		
		Map<String,String> map = new HashMap<>();
		map.put("Message", "User deleted successfully");
		return map;
	}

	@Override
	public userResDto updateUser(userReqDto req) {
		User user =userRepo.findById(req.getUserId());
		if(user != null) {
			user.setUserName(req.getUserName());
			user.setUserEmail(req.getUserEmail());
			
		}
		userResDto dto =DaoToDto(userRepo.save(user));
		return dto;
		
		
	}

	

	@Override
	public userResDto saveUser(userReqDto req) {
		
		User user= new User();
		
		user.setUserName(req.getUserName());
		user.setUserEmail(req.getUserEmail());
		user.setStatus(1);
		
		
		userResDto dto =DaoToDto(userRepo.save(user));
		return dto;
	}

}
