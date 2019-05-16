package com.hcl.abcstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.abcstock.models.Stock;
import com.hcl.abcstock.repositories.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> getAllStocks() {
		
		return stockRepository.findAll();
	}
}
