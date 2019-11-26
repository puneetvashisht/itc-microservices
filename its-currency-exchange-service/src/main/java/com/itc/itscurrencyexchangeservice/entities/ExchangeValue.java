package com.itc.itscurrencyexchangeservice.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
    @Column(name="currency_from")
    String from;
    @Column(name="currency_to")
    String to;
    BigDecimal currency_exchange_rate;
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
    
    
    

}
