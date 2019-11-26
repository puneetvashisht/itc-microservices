package com.itc.itscurrencyconversionservice;

import java.math.BigDecimal;


public class CurrencyConversionBean {
	
	
	int id;
    String from;
    String to;
    BigDecimal currency_exchange_rate;
    BigDecimal totalAmount;
    
    
    
	public CurrencyConversionBean() {
		super();
	}
	public CurrencyConversionBean(int id, String from, String to, BigDecimal currency_exchange_rate,
			BigDecimal totalAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.currency_exchange_rate = currency_exchange_rate;
		this.totalAmount = totalAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getCurrency_exchange_rate() {
		return currency_exchange_rate;
	}
	public void setCurrency_exchange_rate(BigDecimal currency_exchange_rate) {
		this.currency_exchange_rate = currency_exchange_rate;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "CurrencyConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", currency_exchange_rate="
				+ currency_exchange_rate + ", totalAmount=" + totalAmount + "]";
	}
    
    
	

}
