package com.hcl.abcstock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.abcstock.models.Stock;

@Service
public interface StockService {
	
	List<Stock> getAllStocks(); 

}
