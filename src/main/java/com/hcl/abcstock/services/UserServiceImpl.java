package com.hcl.abcstock.services;

import java.time.LocalDate;
import com.hcl.abcstock.errors.StockNotAvailableException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.abcstock.beans.StockPurchaseRequestDto;
import com.hcl.abcstock.models.Stock;
import com.hcl.abcstock.models.Transaction;
import com.hcl.abcstock.models.User;
import com.hcl.abcstock.repositories.StockRepository;
import com.hcl.abcstock.repositories.TransactionRepository;
import com.hcl.abcstock.repositories.UserRepository;


@Service
public class UserServiceImpl  implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public String processPurchase(StockPurchaseRequestDto stockPurchaseRequest) throws StockNotAvailableException {
		
		Stock purchaseStock = stockRepository.findByStockId(stockPurchaseRequest.getStockId());
		Transaction transStock = new Transaction();
		
	//	double  brokeragePrice = 0.0;
		int stockVolume = stockPurchaseRequest.getStockVolume();
		double stockPrice = purchaseStock.getStockPrice();
		if(purchaseStock.getLimitofStocks() < stockVolume) {
			
				throw new StockNotAvailableException("Stock Not Available or limit exceeded");
				
		}
			
		
		if(stockVolume < 500){
			//0.10 % per share
			double percentageStockPrice = percentageOf(stockPrice,0.10);
			transStock.setBrokarageFee(percentageStockPrice * stockVolume);
			transStock.setToatlStockPurchasePrice(stockPrice * stockVolume);
			transStock.setTotalIncludingFee(transStock.getBrokarageFee()+transStock.getToatlStockPurchasePrice());

		}else{
			//stock volume is more than 500
			// 0.15 for every 100 shares no.of.100 shared
			int numOfhunShares = stockVolume/100;
		//	int individualShares = (stockVolume - (numOfhunShares * 100));
			double percentageStockPrice = percentageOf(numOfhunShares * 100 * stockPrice,0.15);
			//we will get for all shares only
			//not charginig any thing less than 100
			transStock.setBrokarageFee(percentageStockPrice * stockVolume);
			transStock.setToatlStockPurchasePrice(stockPrice * stockVolume);
			transStock.setTotalIncludingFee(transStock.getBrokarageFee()+transStock.getToatlStockPurchasePrice());
		}	
		
		transStock.setUserId(stockPurchaseRequest.getUserId());
		transStock.setTimeOfTrade(LocalDate.now());
		transStock.setStockName(purchaseStock.getStockName());
		//currentTranscation.setStockId(purchaseStock.getStockId());
		transStock.setStockPrice(purchaseStock.getStockPrice());
		transStock.setVolumePurchased(stockPurchaseRequest.getStockVolume());

		transactionRepository.save(transStock);
		purchaseStock.setLimitofStocks(purchaseStock.getLimitofStocks()-stockVolume);
		stockRepository.save(purchaseStock);
	
		// TODO Auto-generated method stub
		return "Stocks "+stockVolume+" successfully purchased by user "+stockPurchaseRequest.getUserId();
	}
	
	public double percentageOf(double stockPrice,double stockPercentage){
		//stockPrice * stockPercentage = 100 * x 
		return ((stockPrice * stockPercentage)/100);
	}

}
