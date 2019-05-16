package com.hcl.abcstock.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.abcstock.models.Stock;
import com.hcl.abcstock.models.User;
import com.hcl.abcstock.services.StockService;

@RestController
@RequestMapping("/api")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/stocks", method = RequestMethod.GET)
	public ResponseEntity<List<Stock>> listStocks() {
		logger.info("inside listStocks");
		List<Stock> stocks = stockService.getAllStocks();
		if(stocks.isEmpty()){
			logger.info("Users not available");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(stocks, HttpStatus.OK);
	}

}
