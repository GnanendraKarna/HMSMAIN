package com.hospital.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.exceptions.handler.PatientNotFoundException;
import com.hospital.exceptions.handler.PhysicianNotFoundException;
import com.hospital.repositories.PatientRepository;
import com.hospital.repositories.PhysicianRepository;
import com.hospital.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository repository;

	@Autowired
	private PhysicianRepository physicianRepository;
	
	
	public boolean addPatient(Patient patient) {
		repository.save(patient);
		return true;
	}

	public List<Patient> getAll() {
		return repository.findAll();
	}

	
	public List<Patient> getByPcp(Integer pcp) {
		List<Patient>patient=repository.findByPcp(pcp);
		if (patient.isEmpty()) {
            throw new PatientNotFoundException("No Patient found with pcp: " + pcp);
        }

        return patient;
	}
	public Patient getDetailsByPcp(Integer pcp, Integer ssn)throws PatientNotFoundException,PhysicianNotFoundException {
		Optional<Physician> optionalPcp = physicianRepository.findById(pcp);
		Optional<Patient> optionalSsn = repository.findById(ssn);
		if(optionalSsn.isEmpty()) {
			throw new PatientNotFoundException("Patient not found with id - "+ssn);
		}
		if(optionalPcp.isEmpty()) {
			throw new PhysicianNotFoundException("Physician not found with id - "+pcp);
		}
		return repository.getPatientDetailsBy(optionalPcp.get().getEmployeeid(), optionalSsn.get().getSsn());
	}

	public Integer getInsuranceIdBy(Integer ssn)throws PatientNotFoundException {
		Optional<Patient> optionalSsn = repository.findById(ssn);
		if(optionalSsn.isEmpty()) {
			throw new PatientNotFoundException("Patient not found with Insuranceid - "+ssn);
		}
		return optionalSsn.get().getInsuranceid();
	}

	public Patient updateAddressBy(Integer ssn, String address) {
	    Optional<Patient> optionalPatient = repository.findById(ssn);

	    if (optionalPatient.isPresent()) {
	        Patient patient = optionalPatient.get();
	        patient.setAddress(address);
	        repository.save(patient);
	        return patient;
	    } else {
	        throw new PatientNotFoundException("Patient not found for SSN: " + ssn);
	    }
	}

	public Patient updatePhoneBy(Integer ssn, String phone) {
	    Optional<Patient> optionalPatient = repository.findById(ssn);

	    if (optionalPatient.isPresent()) {
	        Patient patient = optionalPatient.get();
	        patient.setPhone(phone);
	        repository.save(patient);
	        return patient;
	    } else {
	        throw new PatientNotFoundException("Patient not found for SSN: " + ssn);
	    }
	}


}
