package com.example.demo.dto;

import com.example.demo.models.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


   
	@Getter
	@Setter
	@AllArgsConstructor
	@Builder
	public class LightUserDto {

	  private Integer id;

	  @NotNull(message = "Le prenom ne doit pas etre vide")
	  @NotEmpty(message = "Le prenom ne doit pas etre vide")
	  @NotBlank(message = "Le prenom ne doit pas etre vide")
	  private String firstname;

	  @NotNull(message = "Le nom ne doit pas etre vide")
	  @NotEmpty(message = "Le nom ne doit pas etre vide")
	  @NotBlank(message = "Le nom ne doit pas etre vide")
	  private String lastname;

	  public static LightUserDto fromEntity(User user) {
	    // null check
	    return LightUserDto.builder()
	        .id(user.getId())
	        .firstname(user.getFirsname())
	        .lastname(user.getLastname())
	        .build();
	  }

	  public static User toEntity(LightUserDto user) {
	    // null check
	    return User.builder()
	        .id(user.getId())
	        .firsname(user.getFirstname())
	        .lastname(user.getLastname())
	        .build();
	  }

	}



