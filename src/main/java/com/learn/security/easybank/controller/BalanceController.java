package com.learn.security.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
	
	@GetMapping("/myBalance")
	public String getBalanceDetails() {
		return "Wecome to Spring Application Balance Modules ";
	}


}
