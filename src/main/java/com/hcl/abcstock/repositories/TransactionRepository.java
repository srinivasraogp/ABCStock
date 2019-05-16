package com.hcl.abcstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.abcstock.models.Transaction;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Integer> {

}
