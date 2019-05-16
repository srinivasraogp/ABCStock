package com.hcl.abcstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.abcstock.models.Stock;


@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{
	Stock findByStockId(int stockId);

}
