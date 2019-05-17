package com.hcl.abcstock;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.hcl.abcstock.beans.StockPurchaseRequestDto;
import com.hcl.abcstock.errors.StockNotAvailableException;
import com.hcl.abcstock.models.Stock;

import com.hcl.abcstock.repositories.StockRepository;
import com.hcl.abcstock.repositories.TransactionRepository;
import com.hcl.abcstock.services.UserServiceImpl;



@RunWith(MockitoJUnitRunner.class)
public class AbcstockApplicationTests {
	@InjectMocks
	UserServiceImpl userService;
	
	@Mock
	StockRepository stockRepository;
	
	@Mock
	TransactionRepository transactionRepository;
	
    static Stock stockModel= null;
	
    @BeforeClass
	public static void setup() {
    	stockModel= new Stock(); 	
    }	
	 @Test 
	  public void testAddUser() throws StockNotAvailableException 
	  { 
	  stockModel.setStockId(100);
	  stockModel.setStockName("Hcl");
	  stockModel.setStockPrice(50);
	  stockModel.setLimitofStocks(10000);	  
	  StockPurchaseRequestDto stockPurchaseRequest = new StockPurchaseRequestDto();
	  Mockito.when(stockRepository.findByStockId(100)).thenReturn(stockModel);
	  stockPurchaseRequest.setUserId(9999);
	  stockPurchaseRequest.setStockId(100);
	  stockPurchaseRequest.setStockVolume(100);	  
	  String  message1 = userService.processPurchase(stockPurchaseRequest);
	  String  message = "Stocks 100 successfully purchased by user 9999";
	  Assert.assertEquals(message1,message);
	  }

}
