package com.hospital.services.impl;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.hospital.entities.Nurse;
import com.hospital.exceptions.handler.NurseNotFoundException;
import com.hospital.repositories.NurseRepository;
import com.hospital.services.NurseService;
 
@Service
public class NurseServiceImpl implements NurseService {
 
	@Autowired
	private NurseRepository repository;
 
	public Nurse registerNurse(Nurse nurse) {
		return repository.save(nurse);
	}
 
	public List<Nurse> getAll() {
		return repository.findAll();
	}
 
	public Nurse getById(Integer id) {
		Optional<Nurse> optionalNurse = repository.findById(id);
 
		if (optionalNurse.isPresent()) {
			return optionalNurse.get();
		} else {
			throw new NurseNotFoundException("Nurse with ID " + id + " not found");
		}
	}
 
	public String getPositionBy(Integer id) {
		Optional<Nurse> optionalNurse = repository.findById(id);
 
		if (optionalNurse.isPresent()) {
			return optionalNurse.get().getPosition();
		} else {
			throw new NurseNotFoundException("Nurse with ID " + id + " not found");
		}
	}
 
	public boolean getRegisteredBy(Integer id) {
		Optional<Nurse> optionalNurse = repository.findById(id);
 
		if (optionalNurse.isPresent()) {
			return optionalNurse.get().getRegistered();
		} else {
			throw new NurseNotFoundException("Nurse with ID " + id + " not found");
		}
	}
 
	public Nurse updateRegisteredBy(Integer id, Boolean registered) {
		Optional<Nurse> optionalNurse = repository.findById(id);
 
		if (optionalNurse.isPresent()) {
			Nurse nurse = optionalNurse.get();
			nurse.setRegistered(registered);
			repository.save(nurse);
			return nurse;
		} else {
			throw new NurseNotFoundException("Nurse with ID " + id + " not found");
		}
	}
 
	public Nurse updateSsnBy(Integer id, Integer ssn) {
		Optional<Nurse> optionalNurse = repository.findById(id);
 
		if (optionalNurse.isPresent()) {
			Nurse nurse = optionalNurse.get();
			nurse.setSsn(ssn);
			repository.save(nurse);
			return nurse;
		} else {
			throw new NurseNotFoundException("Nurse with ID " + id + " not found");
		}
	}

	@Override
	public Nurse getByName(String name) {
	    return repository.findByName(name);
	}

	
}

