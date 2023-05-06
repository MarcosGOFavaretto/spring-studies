package medi.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medi.voll.api.medic.Medic;
import medi.voll.api.medic.MedicData;
import medi.voll.api.repository.MedicRepository;

@RestController
@RequestMapping("/medics")
public class MedicController {

	@Autowired
	private MedicRepository repository;

	@GetMapping
	public String sayWelcome() {
		return "Welcome to Medics Voll Med API!";
	}

	@PostMapping
	public void createMedic(@RequestBody MedicData data) {
		repository.save(new Medic(data));
	}

}
