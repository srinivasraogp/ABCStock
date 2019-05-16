package com.hcl.abcstock.beans;

import java.io.Serializable;

public class StockPurchaseRequestDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int stockId;
	private int stockVolume;
	private int userId;
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getStockVolume() {
		return stockVolume;
	}
	public void setStockVolume(int stockVolume) {
		this.stockVolume = stockVolume;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
