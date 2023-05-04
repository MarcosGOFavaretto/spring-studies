package medi.voll.api.patient;

import medi.voll.api.address.AddressData;

public record PatientData(
        String name,
        String email,
        String phone,
        String document,
        AddressData address) {}