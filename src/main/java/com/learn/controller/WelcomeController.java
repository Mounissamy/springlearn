package com.learn.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	private MessageSource messageSource;
	//message needs to initalized with this controller
	WelcomeController(MessageSource msgSrc)
	{
		this.messageSource =msgSrc;
	}
	
@GetMapping("/welcome")
	public String sayWelcome() {
		return "Wecome to Spring Application with security ";
	}
@GetMapping("/welcomei18")
public String sayWelcomei18() {
	Locale locale = LocaleContextHolder.getLocale();
	return messageSource.getMessage("good.morning.message", null,"Default Message", locale);
	//return new WelcomeJson("Welcome i18 world");
}

@GetMapping("/welcome/user/{name}")
public WelcomeJson sayWelcomeByName(@PathVariable String name) {
	return new WelcomeJson("Welcome "+ name );
}

}
