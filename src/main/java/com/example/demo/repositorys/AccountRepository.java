package com.example.demo.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Account;

public interface AccountRepository extends JpaRepository<Account,Integer>{

	Object findByIban(String iban);
   Optional<Account> findByUserId (Integer id);
}
