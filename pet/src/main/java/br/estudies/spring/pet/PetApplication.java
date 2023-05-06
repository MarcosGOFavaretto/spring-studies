  package br.estudies.spring.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * That class was automatically generated by Spring Initializr. It is the class
 * where the Spring Boot application is started.
 * 
 * The {@link PetApplication#main(String[])} method calls the
 * {@link SpringApplication} class to bootstraps Tomcat and our Spring
 * applications.
 * 
 * Annotations:
 * - @SpringBootApplication: That annotation triggers the
 * auto-configuration property.
 * 
 * @author MarcosGOFavaretto (marcosfavaretto.dev@gmail.com)
 *
 */
@SpringBootApplication
public class PetApplication {

	/**
	 * That is the Java main method. Its function is to execute the Spring Framework
	 * and prepares a Tomcat server for run it.
	 * 
	 * @param args : an array of command line arguments (not used).
	 */
	public static void main(String[] args) {
		SpringApplication.run(PetApplication.class, args);
	}

}
