package com.itc.itscurrencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itc.itscurrencyexchangeservice.entities.ExchangeValue;
import com.itc.itscurrencyexchangeservice.repos.ExchangeRepository;

@RestController
public class CurrencyExchangeController {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ExchangeRepository exchangeRepository;

	@RequestMapping(path = "/currency-exchange", method = RequestMethod.POST)
	public ResponseEntity<Void> addCurrencyExchange(@RequestBody ExchangeValue exchangeValue) {
		exchangeRepository.save(exchangeValue);
		ResponseEntity<Void> re = new ResponseEntity<>(HttpStatus.CREATED);
		return re;

	}
//	/currency-exchange/from/USD/to/INR 
	@RequestMapping(path = "/currency-exchange/from/{fromCurrency}/to/{toCurrency}", method = RequestMethod.GET)
	public ExchangeValue fetchExchangeRate(@PathVariable("fromCurrency") String from, @PathVariable("toCurrency") String to){
//		return null;
		
		logger.info("*******: " + from);
		//select from exchangevalue where from: from and to: to
		return exchangeRepository.findByFromAndTo(from, to);
//		findBy<FieldName>AND/OR<FieldName2>
	}
	
	
	

}
