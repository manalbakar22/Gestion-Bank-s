package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Adress extends AbstractEntity {
	
	
	private String street;
	private String houseNUmber;
	private Integer zipcode;
	private String city;
	private String country;
  
	
	@OneToOne
	@JoinColumn(name =" id_user")
	private User user;
}
