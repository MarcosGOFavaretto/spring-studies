package medi.voll.api.medic;

import medi.voll.api.address.Address;

public record DadosCadastroMedico(String name, String email, String document, Specialty specialty, Address address) {
}
