package medi.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import medi.voll.api.medic.Medic;

public interface MedicRepository extends JpaRepository<Medic, Long> {
}
