package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.Undergoes;
import com.hospital.entities.id.UndergoesId;

public interface UndergoesRepository extends JpaRepository<Undergoes, UndergoesId> {

}
