package com.hospital.services.impl;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.exceptions.handler.PhysicianNotFoundException;
import com.hospital.repositories.PhysicianRepository;
import com.hospital.services.PhysicianService;
 
@Service
public class PhysicianServiceImpl implements PhysicianService {
 
	@Autowired
	private PhysicianRepository physicianrepo;
 
	@Override
	public boolean registerPhysician(Physician physician) {
		physicianrepo.save(physician);
		return true;
	}
	
	public List<Physician> getAll() {
		return physicianrepo.findAll();
	}
 
	public Physician getByName(String name) {
		Physician physician = physicianrepo.findByName(name);
		if (physician != null) {
            return physician;
        } else {
            throw new PhysicianNotFoundException("Physician not found with name: " + name);
        }
    }
 
	 @Override
	public List<Physician> getByPosition(String position) {
		List<Physician> physicians = physicianrepo.findByPosition(position);
		 if (physicians.isEmpty()) {
	            throw new PhysicianNotFoundException("No physicians found with position: " + position);
	        }
 
	        return physicians;
	}
 
	@Override
	public Physician getByEmpId(Integer id) {
		 Optional<Physician> optionalPhysician = physicianrepo.findById(id);
	        return optionalPhysician.orElseThrow(() -> new PhysicianNotFoundException("Physician not found with ID: " + id));
	    }
 
	@Override
	public Physician updatePosition(Integer id, String position) {
		  Optional<Physician> optionalPhysician = physicianrepo.findById(id);
	        if (optionalPhysician.isPresent()) {
	            Physician physician = optionalPhysician.get();
	            physician.setPosition(position);
	            return physicianrepo.save(physician);
	        } else {
	            throw new PhysicianNotFoundException("Physician not found with ID: " + id);
	        }
	}
 
	@Override
	public Physician updateName(Integer id, String name) {
		Optional<Physician> optionalPhysician = physicianrepo.findById(id);
        if (optionalPhysician.isPresent()) {
            Physician physician = optionalPhysician.get();
            physician.setName(name);
            return physicianrepo.save(physician);
        } else {
            throw new PhysicianNotFoundException("Physician not found with ID: " + id);
        }
	}
 
	@Override
	public Physician updateSSN(Integer id, Integer ssn) {
		Optional<Physician> optionalPhysician = physicianrepo.findById(id);
        if (optionalPhysician.isPresent()) {
            Physician physician = optionalPhysician.get();
            physician.setSsn(ssn);
            return physicianrepo.save(physician);
        } else {
            throw new PhysicianNotFoundException("Physician not found with ID: " + id);
        }
    }
}