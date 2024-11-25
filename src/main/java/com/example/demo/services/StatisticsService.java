package com.example.demo.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.dto.TransactionSumDetails;



public interface StatisticsService {
	 List<TransactionSumDetails> findSumTractionsByDate(LocalDate startDate, LocalDate endDate, Integer userId);

	  BigDecimal getAccountBalance(Integer userId);

	  BigDecimal highestTransfer(Integer userId);

	  BigDecimal highestDeposit(Integer userId);
}
