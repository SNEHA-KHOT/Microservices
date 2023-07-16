package com.UserService.service;

import java.util.List;

import com.UserService.Dto.userReqDto;
import com.UserService.Dto.userResDto;
import com.UserService.model.User;

public interface UserService {
	
	userResDto saveUser (userReqDto req);
	
	userResDto getUser(long userId);
	Object deleteUser(long userId);
	userResDto updateUser(userReqDto req);
	List<userResDto> getAllUsers();

	
}
