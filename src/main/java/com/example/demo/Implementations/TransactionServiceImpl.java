package com.example.demo.Implementations;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.demo.dto.TransactionDto;
import com.example.demo.models.Transaction;
import com.example.demo.models.TransactionType;
import com.example.demo.repositorys.TransactionRepository;
import com.example.demo.services.TransactionService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TransactionServiceImpl implements TransactionService {

	
	private final TransactionRepository transactionRepository;
	@Override
	public Integer save(TransactionDto Dto) {
		Transaction transaction =TransactionDto.toEntity(Dto);
    BigDecimal transactionMultiplier = BigDecimal.valueOf(getTransactionMultiplier(transaction.getType()));

    BigDecimal amount = transaction.getAmount().multiply(transactionMultiplier);
    transaction.setAmount(amount);
		return transactionRepository.save(transaction).getId();
	}

	private long getTransactionMultiplier(TransactionType type) {
		return TransactionType.TRANSFERT == type ? -1 :1;
	}

	@Override
	public List<TransactionDto> findAll() {
		
		return transactionRepository.findAll()
				.stream()
				.map(TransactionDto :: fromEntity)
				.collect(Collectors.toList());
	};
	

	@Override
	public TransactionDto findById(Integer id) {
		
		return transactionRepository.findById(id)
				
				.map(TransactionDto :: fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No user i found with the provided id : :" +id));
	
	}
	

	@Override
	public void delleteById(Integer id) {
		transactionRepository.deleteById(id);
		
	}

	@Override
	public List<TransactionDto> findAllByUserId(Integer id) {
		return transactionRepository.findAllByUserId(userId)
		        .stream()
		        .map(TransactionDto::fromEntity)
		        .collect(Collectors.toList());
	}
	
	

}
