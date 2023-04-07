package br.estudies.spring.pet.pet;

/**
 * Records are immutable classes that requires less implementation of code.
 * 
 * All fields are declared as parameters of a single constructor. After
 * the instantiation of that record class we can access that datas by using
 * the get methods, which are implemented by Java.
 * 
 * That one is a representation of Address, with all address information.
 * 
 * @author MarcosGOFavaretto (marcosfavaretto.dev@gmail.com).
 *
 */
public record Address(String zip_code, String street, String number, String complement, String neighborhood, String city, String state, String country) {
}