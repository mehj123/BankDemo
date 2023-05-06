package com.godel.bankingservice.service;

import java.util.List;

import com.godel.bankingservice.entity.Transaction;

/**
 * Service for inserting and retrieving transactions
 * @author Mehjabeen
 *
 */
public interface TransactionService {

	List<Transaction> getAllTransactions();
	List<Transaction> getTranscationsBySourceAccountId(Long sourceAccountId);
	Transaction saveTransaction(Transaction account);
}
