package br.estudies.spring.pet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {

	@GetMapping
	public String bark() {
		return "Something...";
	}

	@PostMapping
	public void createPet(@RequestBody String body) {
		System.out.println(body);
	}
}
