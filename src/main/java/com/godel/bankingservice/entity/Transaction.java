package com.godel.bankingservice.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Model class for transaction table
 * @author Mehjabeen
 *
 */

@Entity
@Table(name="transaction")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transcationId;
	private Long sourceAccountId;
	private String currency;
	private BigDecimal amount;
	@CreationTimestamp
	private Timestamp createdAt;


	public Long getTranscationId() {
		return transcationId;
	}


	public void setTranscationId(Long transcationId) {
		this.transcationId = transcationId;
	}


	public Long getSourceAccountId() {
		return sourceAccountId;
	}


	public void setSourceAccountId(Long sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "Account [transcationId=" + transcationId + ", sourceAccountId=" + sourceAccountId + ", currency=" + currency + ", amount=" + amount + ", createdAt=" + createdAt +"]";
	}
	
	

}
