package com.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserService.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	
	User findById(long userId);

}
