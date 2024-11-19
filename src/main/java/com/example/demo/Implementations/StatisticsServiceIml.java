package com.example.demo.Implementations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.example.demo.dto.TransactionSumDetails;
import com.example.demo.models.TransactionType;
import com.example.demo.repositorys.TransactionRepository;
import com.example.demo.services.StatisticsService;

public class StatisticsServiceIml implements StatisticsService{

	private final TransactionRepository transactionRepository = null;

	  @Override
	  public List<TransactionSumDetails> findSumTractionsByDate(LocalDate startDate, LocalDate endDate, Integer userId) {
	    LocalDateTime start = LocalDateTime.of(startDate, LocalTime.of(0, 0, 0));
	    LocalDateTime end = LocalDateTime.of(endDate, LocalTime.of(23, 59, 59));
	    return transactionRepository.findSumTransactionsByDate(start, end, userId);
	  }

	  @Override
	  public BigDecimal getAccountBalance(Integer userId) {
	    return transactionRepository.findAccountBalance(userId);
	  }

	  @Override
	  public BigDecimal highestTransfer(Integer userId) {
	    return transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.TRANSFERT);
	  }

	  @Override
	  public BigDecimal highestDeposit(Integer userId) {
	    return transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.DIPOSIF);
	  }
}
