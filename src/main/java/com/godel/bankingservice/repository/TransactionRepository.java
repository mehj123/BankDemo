package com.godel.bankingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godel.bankingservice.entity.Transaction;

/**
 * Repository for querying transaction table
 * @author Mehjabeen
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	List<Transaction> findBySourceAccountId(Long sourceAccountId);
	
}
