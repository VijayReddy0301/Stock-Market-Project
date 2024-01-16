package com.ashokit.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.IStockPriceService;

@RestController
@RequestMapping("/api")
public class StockPriceController {

	private Logger logger = LoggerFactory.getLogger(StockPriceController.class);
	
	@Autowired
	private IStockPriceService service;
	
	
	@GetMapping("/stockPrice/{companyName}")
	public ResponseEntity<Double> getStockPrices(@PathVariable String companyName){
		
		logger.debug("Get Stock Price End Point Called");
		
		Double stockPrice = service.findStockPrice(companyName);
		
		return new ResponseEntity<Double>(stockPrice,HttpStatus.OK);
	}
	
	
	
}
