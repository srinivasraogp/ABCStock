package com.hcl.abcstock.services;

import java.util.List;

import com.hcl.abcstock.models.User;
import com.hcl.abcstock.beans.*;
import com.hcl.abcstock.errors.StockNotAvailableException;

public interface UserService {

	List<User> findAllUsers();
	public String processPurchase(StockPurchaseRequestDto stockPurchaseRequest) throws StockNotAvailableException;
	public double percentageOf(double stockPrice,double stockPercentage);
}
