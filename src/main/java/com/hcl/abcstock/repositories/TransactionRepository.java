package com.hcl.abcstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.abcstock.models.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction, Integer> {

}
