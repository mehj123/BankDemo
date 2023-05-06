package com.godel.bankingservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godel.bankingservice.entity.Transaction;
import com.godel.bankingservice.repository.TransactionRepository;

/**
 * Implementation class for inserting and retrieving transactions
 * @author Mehjabeen
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	private static final String CLASSNAME = TransactionServiceImpl.class.getName();
	private static final Logger logger = LoggerFactory.getLogger(CLASSNAME);

	
	@Override
	public List<Transaction> getAllTransactions() {
		final String methodName = "getAllTransactions()";
		logger.debug("Inside {} of {}", methodName, CLASSNAME);
		return transactionRepository.findAll();
	}

	@Override
	public List<Transaction> getTranscationsBySourceAccountId(Long sourceAccountId) {
		final String methodName = "getTranscationsBySourceAccountId()";
		logger.debug("Inside {} of {}", methodName, CLASSNAME);
		return transactionRepository.findBySourceAccountId(sourceAccountId);
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		final String methodName = "saveTransaction()";
		logger.debug("Inside {} of {}", methodName, CLASSNAME);
		return transactionRepository.save(transaction);
		
	}

}
