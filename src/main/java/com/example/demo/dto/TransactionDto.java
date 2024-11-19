package com.example.demo.dto;

import java.math.BigDecimal;

import com.example.demo.models.Transaction;
import com.example.demo.models.TransactionType;
import com.example.demo.models.User;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransactionDto {
	
	
	private Integer id;
    private BigDecimal amount;
	private TransactionType type;
	private String DestinationIban;
	private Integer userId;
	
	
	public static TransactionDto fromEntity(Transaction transaction) {
		return TransactionDto.builder()
				.id(transaction.getId())
				.amount(transaction.getAmount())
				.type(transaction.getType())
				.userId(transaction.getUser().getId())
				
				
				.build();
		
	}
	
	public static Transaction toEntity(TransactionDto transaction) {
		return Transaction.builder()
				.id(transaction.getId())
				.amount(transaction.getAmount())
				.type(transaction.getType())
				 .user(
			    		  User.builder()
			    		      .id(transaction.getUserId())
			    		    		  .build()
			    		  )
				
				
				.build();
		
	}
	
	
	
	
	

}
