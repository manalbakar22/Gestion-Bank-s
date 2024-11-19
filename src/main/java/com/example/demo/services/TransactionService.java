package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.TransactionDto;

public interface TransactionService extends AbstractServices<TransactionDto>{
  List<TransactionDto> findAllByUserId(Integer userId);
}
