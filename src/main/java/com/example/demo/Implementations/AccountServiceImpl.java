package com.example.demo.Implementations;

import java.util.List;
import java.util.Locale.IsoCountryCode;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bouali.banking.exceptions.OperationNonPermittedException;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AdressDto;
import com.example.demo.models.Account;
import com.example.demo.repositorys.AccountRepository;
import com.example.demo.services.AccountService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class AccountServiceImpl implements AccountService {
	private final AccountRepository accountrepository;

	@Override
	public Integer save(AccountDto Dto) {
		
		
		Account account = AccountDto.toEntity(Dto);
	    boolean userHasAlreadyAnAccount = accountrepository.findByUserId(account.getUser().getId()).isPresent();
	    if (userHasAlreadyAnAccount && account.getUser().isActive()) {
	      throw new OperationNonPermittedException(
	          "the selected user has already an active account",
	          "Create account",
	          "Account service",
	          "Account creation"
	      );}
	}

	@Override
	public List<AccountDto> findAll() {
		
		return  accountrepository.findAll()
				.stream()
				.map(AccountDto :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public AccountDto findById(Integer id) {
		
		return  accountrepository.findById(id)
				
				.map(AccountDto :: fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No user i found with the provided id : :" +id));
	
	}

	@Override
	public void delleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	/*
	private String generatedRandomIban() {
		String Iban = Iban.random(IsoCountryCode.DE).toFormattedString();
		boolean ibanExist = accountrepository.findByIban(Iban).ispresent();
	if (ibanExist) {
		generatedRandomIban();
	}
	return Iban;
		
	}
*/
	
	
	

}
