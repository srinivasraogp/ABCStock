package com.hcl.abcstock.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class Stock {
	
    @Id		
    @Column(name="Stock_Id")
	private int stockId;
	private String stockName;
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	private double stockPrice;
	private int limit;
}