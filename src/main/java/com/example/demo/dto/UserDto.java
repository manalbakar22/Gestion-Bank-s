package com.example.demo.dto;

import com.example.demo.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class UserDto {
	
	
	private String firsname;
	private String lastname;
	private String email;
	private String password;
	
	
	public static UserDto fromEntity(User user) {
		return UserDto.builder()
				.firsname(user.getFirsname())
				.lastname(user.getLastname())
				.email(user.getEmail())
				.password(user.getPassword())
				.build();
				
	}
	
	public static User toEntity(UserDto user) {
		return User.builder()
				.firsname(user.getFirsname())
				.lastname(user.getLastname())
				.email(user.getEmail())
				.password(user.getPassword())
				.build();
				
	}

}
