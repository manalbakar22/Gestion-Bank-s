package com.example.demo.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class Transaction extends AbstractEntity {
	
	
	
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	
	private String DestinationIban;
	
	
	
	@ManyToOne
	@JoinColumn(name= "id_user")
	private User user;
	

}
