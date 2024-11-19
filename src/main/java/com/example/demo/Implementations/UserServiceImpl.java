package com.example.demo.Implementations;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.Account;
import com.example.demo.models.User;
import com.example.demo.repositorys.UserRepository;
import com.example.demo.services.AccountService;
import com.example.demo.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor


public class UserServiceImpl implements UserService{
	 private final UserRepository repository;

	  private final AccountService accountService;
	
	

	@Override
	public Integer save(UserDto Dto) {
		User user = UserDto.toEntity(Dto);
		return repository.save(user).getId();
		
		
	}

	@Override
	public List<UserDto> findAll() {
		
		return repository.findAll()
				.stream()
				.map(UserDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto findById(Integer id) {
		
		return repository.findById(id)
				.map(UserDto ::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No user i found with the provided id : :"+ id));
	}

	@Override()
	public void delleteById(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	  @jakarta.transaction.Transactional
	  public Integer validateAccount(Integer id) {
	    User user = repository.findById(id)
	        .orElseThrow(() -> new EntityNotFoundException("No user was found for user account validation"));

	    if (user.getAccount() == null) {
	      // create a bank account
	      AccountDto account = AccountDto.builder()
	          .user(UserDto.fromEntity(user))
	          .build();
	      var savedAccount = accountService.save(account);
	      user.setAccount(
	          Account.builder()
	              .id(savedAccount)
	              .build()
	      );
	    }

	    user.setActive(true);
	    repository.save(user);
	    return user.getId();
	  }

	  @Override
	  public Integer invalidateAccount(Integer id) {
	    User user = repository.findById(id)
	        .orElseThrow(() -> new EntityNotFoundException("No user was found for user account validation"));

	    user.setActive(false);
	    repository.save(user);
	    return user.getId();
	  }
}
