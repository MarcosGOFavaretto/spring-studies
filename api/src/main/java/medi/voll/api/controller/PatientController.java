package medi.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medi.voll.api.patient.PatientData;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @PostMapping
    public void createPatient(@RequestBody PatientData body) {
        System.out.println("Received body: " + body);
    }

}
