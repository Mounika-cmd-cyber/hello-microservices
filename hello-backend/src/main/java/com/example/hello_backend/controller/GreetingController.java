package com.example.hello_backend.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello_backend.repository.PersonRepository;

import com.example.hello_backend.model.Person;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GreetingController {
	   @Autowired
	    private PersonRepository personRepository;

	    @GetMapping("/api/name")
	    public String getName() {
	        // Take first person from DB (or default "Mounika")
	        return personRepository.findAll().stream()
	                .findFirst()
	                .map(Person::getName)
	                .orElse("Mounika");
	    }

}
