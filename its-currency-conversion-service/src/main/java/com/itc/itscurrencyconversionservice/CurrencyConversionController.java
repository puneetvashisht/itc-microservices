package com.itc.itscurrencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CurrencyConversionController {
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("to") String to,
			@PathVariable("from") String from,
			@PathVariable("quantity") BigDecimal quantity){
		
		
		// Invoke a REST-API (localhost:8000/currency-exchange/from/USD/to/INR)
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		
		//1. URL is hard-coded
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversionBean.class, 
				uriVariables );
		
		CurrencyConversionBean response = responseEntity.getBody();
		
		response.setTotalAmount(quantity.multiply(response.getCurrency_exchange_rate()));
		
		System.out.println("------------------- " + response);
		
		return response;
		
	}
	
	@GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable("to") String to,
			@PathVariable("from") String from,
			@PathVariable("quantity") BigDecimal quantity){
		System.out.println(to + " ****** " + from);
		CurrencyConversionBean response = currencyExchangeServiceProxy.fetchExchangeRate(from, to);
		response.setTotalAmount(quantity.multiply(response.getCurrency_exchange_rate()));
		
		System.out.println("------------------- " + response);
		
		return response;
		
		// Invocation Code
	}
	
	


}
