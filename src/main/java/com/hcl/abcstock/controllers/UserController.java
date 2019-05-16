package com.hcl.abcstock.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.abcstock.beans.StockPurchaseRequestDto;
import com.hcl.abcstock.errors.StockNotAvailableException;
import com.hcl.abcstock.models.Transaction;
import com.hcl.abcstock.models.User;
import com.hcl.abcstock.services.UserService;


@RestController
@RequestMapping(path="/api")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;  

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listUsers() {
		logger.info("inside listUsers");
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			logger.info("Users not available");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	
	@PostMapping("/PurchaseStock")
	public ResponseEntity<String> purchaseStocks(StockPurchaseRequestDto stockPurchaseRequest) throws StockNotAvailableException{
		String message = null;	
		logger.debug("Stock Purchasing Starts ==========>> ");
		
		message = userService.processPurchase(stockPurchaseRequest);
		
		logger.debug("Stock Purchasing Ends ==========>> ");
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/users/transactions/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> listTransactionsForUsers(@PathVariable int userId) {
		logger.info("inside listTransactionsForUsers");
		List<Transaction> transactions = userService.getAllTransationForUser(userId);
		if(transactions.isEmpty()){
			logger.info("Transaction not available for user");
			return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
}
