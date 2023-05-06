package com.godel.bankingservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godel.bankingservice.entity.Transaction;
import com.godel.bankingservice.service.TransactionService;

/**
 * Controller class for the Banking Demo application
 * 
 * @author Mehjabeen
 *
 */
@RestController
@RequestMapping("/bankingservice")
public class BankDemoController {

	private static final String CLASSNAME = BankDemoController.class.getName();
	private static final Logger logger = LoggerFactory.getLogger(CLASSNAME);

	@Autowired
	private TransactionService transcationService;
	

	/**
	 * Returns all transaction available in the database
	 * 
	 * @return List<Transaction>
	 */
	@GetMapping("/transcations")
	public List<Transaction> getAllTransactions() {
		final String methodName = "getAllTransactions()";
		logger.debug("Entering {} of {}", methodName, CLASSNAME);

		List<Transaction> transactionList = new ArrayList<>();

		transactionList = transcationService.getAllTransactions();
		logger.debug("Exiting {} of {}", methodName, CLASSNAME);
		return transactionList;
	}

	/**
	 * Returns transactions for a particular source account id
	 * 
	 * @param accountId List<Transaction>
	 * @return
	 */
	@GetMapping("/transcations/{sourceAccountId}")
	public List<Transaction> getTranscationsByAccountId(
			@PathVariable("sourceAccountId") Long accountId) {
		final String methodName = "getTranscationsByAccountId()";
		logger.debug("Entering {} of {}", methodName, CLASSNAME);

		List<Transaction> transactionList = new ArrayList<>();

		transactionList = transcationService.getTranscationsBySourceAccountId(accountId);
		logger.info("transactionList : " + transactionList);
		
		logger.debug("Exiting {} of {}", methodName, CLASSNAME);
		return transactionList;
	}
	
	/**
	 * Saves the new transaction in the database
	 * @param newTransaction
	 * @param sourceAccountId
	 * @return
	 */
	@PostMapping("/transcations/{sourceAccountId}")
	public Transaction saveAccountTransaction(@RequestBody Transaction newTransaction,
			@PathVariable("sourceAccountId") Long sourceAccountId) {
		final String methodName = "saveAccountTransaction()";
		logger.debug("Entering {} of {}", methodName, CLASSNAME);

		Transaction account = transcationService.saveTransaction(newTransaction);

		logger.debug("Exiting {} of {}", methodName, CLASSNAME);
		return account;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
	    return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
