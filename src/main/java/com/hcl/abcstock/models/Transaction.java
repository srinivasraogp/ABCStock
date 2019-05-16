package com.hcl.abcstock.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="Transaction_Id")
	 private int transactionId;
	 private int userId;
	 private LocalDate timeOfTrade;
	 public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDate getTimeOfTrade() {
		return timeOfTrade;
	}
	public void setTimeOfTrade(LocalDate timeOfTrade) {
		this.timeOfTrade = timeOfTrade;
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
	public int getVolumePurchased() {
		return volumePurchased;
	}
	public void setVolumePurchased(int volumePurchased) {
		this.volumePurchased = volumePurchased;
	}
	public double getToatlStockPurchasePrice() {
		return toatlStockPurchasePrice;
	}
	public void setToatlStockPurchasePrice(double toatlStockPurchasePrice) {
		this.toatlStockPurchasePrice = toatlStockPurchasePrice;
	}
	public double getBrokarageFee() {
		return brokarageFee;
	}
	public void setBrokarageFee(double brokarageFee) {
		this.brokarageFee = brokarageFee;
	}
	public double getTotalIncludingFee() {
		return totalIncludingFee;
	}
	public void setTotalIncludingFee(double totalIncludingFee) {
		this.totalIncludingFee = totalIncludingFee;
	}
	private String stockName;
	 private double stockPrice;
	 private int volumePurchased;
	 private double toatlStockPurchasePrice;
	 private double brokarageFee;
	 private double totalIncludingFee;

}
