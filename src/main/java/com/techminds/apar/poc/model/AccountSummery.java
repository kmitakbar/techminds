package com.techminds.apar.poc.model;


import lombok.Data;

@Data
public class AccountSummery{
	private String date;
	private Double payableAmt, receivableAmt;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getPayableAmt() {
		return payableAmt;
	}
	public void setPayableAmt(Double payableAmt) {
		this.payableAmt = payableAmt;
	}
	public Double getReceivableAmt() {
		return receivableAmt;
	}
	public void setReceivableAmt(Double receivableAmt) {
		this.receivableAmt = receivableAmt;
	}
	
	
}
