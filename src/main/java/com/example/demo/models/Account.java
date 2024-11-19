package com.example.demo.models;

import java.time.LocalDateTime;

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

public class Account extends AbstractEntity {
	
	
	
	
	private String Iban;
	private LocalDateTime creationDate;
	private LocalDateTime LastUpdate;
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	

}
