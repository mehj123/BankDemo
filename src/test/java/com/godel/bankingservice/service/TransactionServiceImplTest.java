package com.godel.bankingservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.godel.bankingservice.entity.Transaction;
import com.godel.bankingservice.repository.TransactionRepository;

class TransactionServiceImplTest {
	
	@InjectMocks
	TransactionServiceImpl service;
	
	@Mock
	TransactionRepository repository;
	
	Transaction transaction;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		transaction = new Transaction();
		transaction.setTranscationId(1L);
		transaction.setSourceAccountId(1234L);
		transaction.setCurrency("ABC");
		transaction.setAmount(new BigDecimal(100));
	}
	@Test
	void testGetAllTransactions() {
		when(repository.findAll()).thenReturn(Collections.singletonList(transaction));
		List<Transaction> actualTransaction = service.getAllTransactions();
		assertNotNull(actualTransaction);
		assertEquals(transaction, actualTransaction.get(0));
	}

	@Test
	void testGetTranscationsBySourceAccountId() {
		when(repository.findBySourceAccountId(1L)).thenReturn(Collections.singletonList(transaction));
		List<Transaction> actualTransaction = service.getTransactionsBySourceAccountId(1L);
		assertNotNull(actualTransaction);
		assertEquals(transaction, actualTransaction.get(0));
	}

	@Test
	void testSaveTransaction() {
		when(repository.save(transaction)).thenReturn(transaction);
		Transaction actualTransaction = service.saveTransaction(transaction);
		assertNotNull(actualTransaction);
		assertEquals(transaction, actualTransaction);
	}

}
