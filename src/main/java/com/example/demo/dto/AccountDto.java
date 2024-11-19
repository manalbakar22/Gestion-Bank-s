package com.example.demo.dto;

import com.example.demo.models.Account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public

 class AccountDto {
	
	private Integer id;
	private String Iban;
	private UserDto user;
	
	
	public static AccountDto fromEntity (Account account) {
		
		return AccountDto.builder()
		.id(account.getId())
		.Iban(account.getIban())
		.user(UserDto.fromEntity(account.getUser()))
		.build();
	}
	
   public static Account toEntity (AccountDto account) {
		
		return Account.builder()
		.id(account.getId())
		.Iban(account.getIban())
		.user(UserDto.toEntity(account.getUser()))
		.build();
	}
	

}
