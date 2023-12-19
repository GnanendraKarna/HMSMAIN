package com.hospital.services;

import java.util.List;

import com.hospital.entities.Nurse;

public interface NurseService {

	Nurse registerNurse(Nurse nurse);

	List<Nurse> getAll();
	Nurse getByName(String name);

	Nurse getById(Integer id);

	String getPositionBy(Integer id);

	boolean getRegisteredBy(Integer id);

	Nurse updateRegisteredBy(Integer id, Boolean registered);

	Nurse updateSsnBy(Integer id, Integer ssn);

}
