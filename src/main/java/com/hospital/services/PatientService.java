package com.hospital.services;

import java.util.List;

import com.hospital.entities.Patient;

public interface PatientService {

	boolean addPatient(Patient patient);

	List<Patient> getAll();

	List<Patient> getByPcp(Integer pcp);

	Patient getDetailsByPcp(Integer pcp, Integer ssn);

	Integer getInsuranceIdBy(Integer ssn);

	Patient updateAddressBy(Integer ssn, String address);

	Patient updatePhoneBy(Integer ssn, String phone);

}
