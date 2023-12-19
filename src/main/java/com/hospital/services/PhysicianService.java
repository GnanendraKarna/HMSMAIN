package com.hospital.services;

import java.util.List;

import com.hospital.entities.Patient;
import com.hospital.entities.Physician;

public interface PhysicianService {

	boolean registerPhysician(Physician physician);

	Physician getByName(String name);
	
	List<Physician> getAll();

	List<Physician> getByPosition(String position);

	Physician getByEmpId(Integer id);

	Physician updatePosition(Integer id, String position);

	Physician updateName(Integer id, String name);

	Physician updateSSN(Integer id, Integer ssn);
}
