package medi.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import medi.voll.api.patient.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
