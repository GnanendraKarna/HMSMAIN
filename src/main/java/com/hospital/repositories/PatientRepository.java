package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.entities.Patient;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	List<Patient> findByPcp(Integer pcp);

	@Query("select p from Patient p where p.pcp= :physicianid and p.ssn= :patientid")
	Patient getPatientDetailsBy(Integer physicianid, Integer patientid);

}
