package medi.voll.api.medic;

import medi.voll.api.address.AddressData;

public record MedicData(String name, String email, String document, Specialty specialty, AddressData address) {
}
