package com.hcl.abcstock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Stock {
	
    @Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public int getLimitofStocks() {
		return limitofStocks;
	}
	public void setLimitofStocks(int limitofStocks) {
		this.limitofStocks = limitofStocks;
	}
	private double stockPrice;
	private int limitofStocks;
}