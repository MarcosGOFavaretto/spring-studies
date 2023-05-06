package br.studies.spring.pet.pet;

/**
 * Records are immutable classes that requires less implementation of code.
 * 
 * All fields are declared as parameters of a single constructor. After
 * the instantiation of that record class we can access that datas by using
 * the get methods, which are implemented by Java.
 * 
 * That one is a representation of Pet, with its name, age and owner.
 * 
 * @author MarcosGOFavaretto (marcosfavaretto.dev@gmail.com).
 *
 */
public record PetDTO(String name, double age, OwnerDTO owner) {
}
