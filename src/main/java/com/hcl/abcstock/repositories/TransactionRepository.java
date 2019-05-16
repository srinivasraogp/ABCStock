package com.hcl.abcstock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.abcstock.models.Transaction;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Integer> {

	List<Transaction>findAllByUserId(int userId);
}
