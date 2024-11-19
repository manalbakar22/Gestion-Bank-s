package com.example.demo.services;

import com.example.demo.dto.LightUserDto;
import com.example.demo.dto.UserDto;

public interface UserService extends AbstractServices<UserDto>{
	
	Integer validateAccount(Integer id);
	Integer invalidateAccount(Integer id);
	void delete(Integer userId);
	
	

}