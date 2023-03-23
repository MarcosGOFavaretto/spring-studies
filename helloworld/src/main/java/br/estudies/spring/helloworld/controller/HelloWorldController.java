package br.estudies.spring.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * That class is a Controller which allow us to make HTTP requests.
 * 
 * Annotations:
 * - @RestController: Declares that class as a RESTFull Controller,
 * making it responsible for deal with HTTP requests.
 * - @RequestMapping: Defines the end-point that class has to listen
 * to.
 * - @GetMapping: Defines which method has to be executed when a GET
 * request is received.
 * 
 * @author MarcosGOFavaretto (marcosfavaretto.dev@gmail.com)
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	/**
	 * 
	 * That is the implementation of GET HTTP verb.
	 * 
	 * @return a message saying "Hello World!" for everybody.
	 */
	@GetMapping
	public String sayHello() {
		return "Hello World!";
	}
}
