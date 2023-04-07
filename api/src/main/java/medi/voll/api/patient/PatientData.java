package medi.voll.api.patient;

import medi.voll.api.address.Address;

public record PatientData(
        String name,
        String email,
        String phone,
        String document,
        Address address) {}