package br.estudies.spring.pet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * That class is a Rest Controller, which allow us to make HTTP requests.
 * 
 * Annotations:
 * - @RestController: Declares that class as a RESTFull Controller,
 * making it responsible for deal with HTTP requests.
 * - @RequestMapping: Defines the end-point that class has to listen to.
 * - @GetMapping: Defines which method has to be executed when a GET
 * request is received.
 * - @PostMapping: Defines which method has to be executed when a POST
 * request is received.
 * - @RequestBody: Populate a parameter with the request body provided.
 * 
 * @author MarcosGOFavaretto (marcosfavaretto.dev@gmail.com)
 *
 */
@RestController
@RequestMapping("/pets")
public class PetController {

	/**
	 * 
	 * That is the implementation of GET HTTP verb.
	 * 
	 * @return a message saying "something..." for everybody.
	 */
	@GetMapping
	public String bark() {
		return "Something...";
	}

	/**
	 * 
	 * That is the implementation of POST HTTP verb.
	 * 
	 * @param body: is the provided JSON body of recived request.
	 */
	@PostMapping
	public void createPet(@RequestBody String body) {
		System.out.println(body);
	}
}
