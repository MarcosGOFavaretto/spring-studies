package medi.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medi.voll.api.medic.MedicData;

/**
 * That class is a Controller which allow us to make HTTP requests.
 * 
 * Annotations:
 * - @RestController: Declares that class as a RESTFull Controller,
 * making it responsible for deal with HTTP requests.
 * - @RequestMapping: Defines the end-point that class has to listen
 * to.
 * - @PostMapping: Defines which method has to be executed when a POST
 * request is received.
 * - @RequestBody: Populate a parameter with the request body provided.
 * 
 * @author MarcosGOFavaretto (marcosfavaretto.dev@gmail.com)
 *
 */
@RestController
@RequestMapping("/medics")
public class MedicController {

	@PostMapping
	public void createMedic(@RequestBody MedicData data) {
		System.out.println(data);
	}

}
