package com.example.demo.dto;

import com.example.demo.models.Adress;
import com.example.demo.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor

public  class AdressDto {
	
	private Integer id;
	private String street;
	private String houseNUmber;
	private Integer zipcode;
	private String city;
	private String country;
	private Integer userId;
	
	public static AdressDto fromAdressEntity(Adress adress) {
		return AdressDto.builder()
		      .id(adress.getId())
		      .street(adress.getStreet())
		      .houseNUmber(adress.getHouseNUmber())
		      .zipcode(adress.getZipcode())
		      .city(adress.getCity())
		      .country(adress.getCountry())
		      .userId(adress.getUser().getId())
		      .build();
	}
	
	public static Adress toAdressEntity(AdressDto adress) {
		return Adress.builder()
		      .id(adress.getId())
		      .street(adress.getStreet())
		      .houseNUmber(adress.getHouseNUmber())
		      .zipcode(adress.getZipcode())
		      .city(adress.getCity())
		      .country(adress.getCountry())
		      .user(
		    		  User.builder()
		    		      .id(adress.getUserId())
		    		    		  .build()
		    		  )
		      
		      .build();
	}
  

}
