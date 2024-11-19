package com.example.demo.services;
import java.util.List;

import com.example.demo.dto.AccountDto;

public interface AccountService extends AbstractServices<AccountDto>{
	List<AccountDto> findAllById (Integer userId);

}
