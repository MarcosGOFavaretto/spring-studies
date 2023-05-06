package medi.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medi.voll.api.medic.MedicData;

@RestController
@RequestMapping("/medics")
public class MedicController {

	@GetMapping
	public String sayWelcome() {
		return "Welcome to Medics Voll Med API!";
	}

	@PostMapping
	public void createMedic(@RequestBody MedicData data) {
		System.out.println(data);
	}

}
