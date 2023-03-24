package com.learn.version.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.controller.model.Person;
import com.learn.controller.model.Person2;

@RestController
public class PersonVersioningControoler {

	/**\
	 * Version can be done 4 ways.
	 * 1. URL versioning
	 * 2. Request Param versinig
	 * 3. Customer Headers
	 * 4. Media Type like content Negotations 
	 */
	public PersonVersioningControoler() {}
	//Versioning with URL like /v1/person, /v2/person
   @GetMapping("/v1/person")
	public Person getPersonV1()
	{
		return new Person("Mounisamy Souprayane");
		
	}
   
   @GetMapping("/v2/person")
  	public Person2 getSecondPersonV2()
  	{
  		return new Person2("Mounisamy", "Souprayane");
  	}
 //Versioning with Request Parameter /person?version=1, /person?version=2
   @GetMapping(path = "/person", params = "version=1")
	public Person getPersonV1UsingRequestParm()
	{
		return new Person("Mounisamy Souprayane  Souprayane_using Request Param");
		
	}
   
   @GetMapping(path = "/person", params = "version=2")
  	public Person2 getPersonV2UsingRequestParm()
  	{
  		return new Person2("Mounisamy", "Souprayane_using Request Param");
  	}
     
 //Versioning with Request Request Header /X-API-Version=1, /X-API-Version=2
   @GetMapping(path = "/person/headers", headers="X-API-Version=1")
	public Person getPersonV1UsingHeaders()
	{
		return new Person("Mounisamy Souprayane  Souprayane_using Headers");
		
	}
   
   @GetMapping(path = "/person/headers", headers ="X-API-Version=2")
  	public Person2 getPersonV2UsingHeaders()
  	{
  		return new Person2("Mounisamy", "Souprayane_using Headers");
  	}
   
 //Versioning with Request accept Header 
   @GetMapping(path = "/person/accept", produces ="application/vnd.company.app-v1+json")
	public Person getPersonV1UsingAccept()
	{
		return new Person("Mounisamy Souprayane  Souprayane_using Headers");
		
	}
   
   @GetMapping(path = "/person/accept", produces ="application/vnd.company.app-v2+json")
  	public Person2 getPersonV2UsingAccept()
  	{
  		return new Person2("Mounisamy", "Souprayane_using Headers");
  	}
   
}
