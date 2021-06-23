package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ClientConfig;
import com.example.demo.entity.Person;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ClientController {
   @GetMapping("/people")
   public Flux<Person> getPerson(){
	   return ClientConfig.getWc()
	           .get()
			   .uri("api/people")
			   .retrieve()
			   .bodyToFlux(Person.class);
   }
	
}
