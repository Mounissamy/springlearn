package com.learn.security.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	@GetMapping("/myLoan")
	public String getLoanDetails() {
		return "Wecome to Spring Application Loan Modules ";
	}

}
