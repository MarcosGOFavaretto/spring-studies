package medi.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medi.voll.api.patient.Patient;
import medi.voll.api.patient.PatientData;
import medi.voll.api.repository.PatientRepository;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @GetMapping
	public String sayWelcome() {
		return "Welcome to Patients Voll Med API!";
	}

    @PostMapping
    public void createPatient(@RequestBody PatientData body) {
        repository.save(new Patient(body));
    }

}
