package com.hospital.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.entities.Procedure;
import com.hospital.exceptions.handler.ProcedureNotFoundException;
import com.hospital.repositories.ProcedureRepository;
import com.hospital.services.ProcedureService;

@Service
public class ProcedureServiceImpl implements ProcedureService {

	@Autowired
	private ProcedureRepository procedureRepository;

	public boolean addTreatment(Procedure procedure) {
		procedureRepository.save(procedure);
		return true;
	}

	public List<Procedure> getAll() {
		 try {
	            return procedureRepository.findAll();
	        } catch (Exception e) {
	            throw new ProcedureNotFoundException("Error fetching all procedures");
	        }
	}

	public Procedure getCostBy(Integer id) {
		try {
            Optional<Procedure> optionalProcedure = procedureRepository.findById(id);
            return optionalProcedure.orElseThrow(() -> new ProcedureNotFoundException("Procedure not found with ID: " + id));
        } catch (Exception e) {
            throw new ProcedureNotFoundException("Error fetching procedure cost by ID");
        }
    }

	public Procedure getCostByName(String name) {
		try {
			Optional<Procedure> optionalProcedure = Optional.ofNullable(procedureRepository.findCostByName(name));
			return optionalProcedure.orElseThrow(() -> new ProcedureNotFoundException("Procedure not found with ID: " + name));
        } catch (Exception e) {
            throw new ProcedureNotFoundException("Error fetching procedure cost by name");
        }
    }

	public Procedure updateCostBy(Integer id, Double cost) {
	    Optional<Procedure> optionalProcedure = procedureRepository.findById(id);

	    if (optionalProcedure.isPresent()) {
	        Procedure procedure = optionalProcedure.get();
	        procedure.setCost(cost);
	        procedureRepository.save(procedure);
	        return procedure;
	    } else {
	        throw new ProcedureNotFoundException("Procedure not found for id: " + id);
	    }
	}

	public Procedure updateNameBy(Integer id, String name) {
	    Optional<Procedure> optionalProcedure = procedureRepository.findById(id);

	    if (optionalProcedure.isPresent()) {
	        Procedure procedure = optionalProcedure.get();
	        procedure.setName(name);
	        procedureRepository.save(procedure);
	        return procedure;
	    } else {
	        throw new ProcedureNotFoundException("Procedure not found for id: " + id);
	    }
	}

}
