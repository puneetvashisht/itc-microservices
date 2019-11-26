package com.itc.itscurrencyexchangeservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.itscurrencyexchangeservice.entities.ExchangeValue;

public interface ExchangeRepository extends JpaRepository<ExchangeValue, Integer>{
	public ExchangeValue findByFromAndTo(String from, String to);

}
