package com.itc.itscurrencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import com.itc.itscurrencyexchangeservice.entities.ExchangeValue;
@FeignClient(name="its-currency-exchange-service", url="localhost:8000")

public interface CurrencyExchangeServiceProxy {
	
	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean fetchExchangeRate(@PathVariable("from") String from, @PathVariable("to") String to); 

}
