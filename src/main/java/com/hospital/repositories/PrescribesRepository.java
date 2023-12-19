package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.Prescribes;
import com.hospital.entities.id.PrescribesId;

public interface PrescribesRepository extends JpaRepository<Prescribes, PrescribesId> {

}
