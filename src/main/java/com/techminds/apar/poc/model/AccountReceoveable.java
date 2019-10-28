package com.techminds.apar.poc.model;

import java.util.Date;

import lombok.Data;

@Data
public class AccountReceoveable {
	private String accountNumber;
	private String sellerId;
	private String soldDate;
	private Double amount;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(String string) {
		this.soldDate = string;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	

}
