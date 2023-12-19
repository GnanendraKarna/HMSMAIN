package com.hospital.services.impl;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entities.Physician;
import com.hospital.entities.Procedure;
import com.hospital.entities.TrainedIn;
import com.hospital.exceptions.handler.TrainedInNotFoundException;
import com.hospital.repositories.TrainedInRepository;
import com.hospital.services.TrainedInService;

@Service
public class TrainedInServiceImpl implements TrainedInService {

	@Autowired
	private TrainedInRepository trainedInRepository;

	@Override
	public boolean addCertificate(TrainedIn certificate) {
		trainedInRepository.save(certificate);
		return true;
	}

	@Override
	public List<TrainedIn> getProcedureByCertification() {
		try {
            return trainedInRepository.findAll();
        } catch (Exception e) {
            throw new TrainedInNotFoundException("Error fetching all certificates");
        }
    }

	@Override
	public List<Procedure> getTreatment(Integer physicianid) {
		List<Procedure> procedure = trainedInRepository.findTreatmentByPhysician(physicianid);
		 if (procedure.isEmpty()) {
	            throw new TrainedInNotFoundException("No treatment found with physicianid: " + physicianid);
	        }
	        return procedure;
	}

	@Override
	public List<Physician> getPhysicican(Integer procedureid) {
		List<Physician> procedure = trainedInRepository.findPhysicianByTreatment(procedureid);
		 if (procedure.isEmpty()) {
	            throw new TrainedInNotFoundException("No physician found with treatment: " + procedureid);
	        }
	        return procedure;
	}

	public TrainedIn updateCertificationExpires(Integer physicianid, Integer procedureid, Date certificationexpires) {
	    TrainedIn trained = trainedInRepository.findByPhysicianAndProcedure(physicianid, procedureid);

	    if (trained == null) {
	        throw new TrainedInNotFoundException("TrainedIn not found for physicianId: " + physicianid + " and procedureId: " + procedureid);
	    }

	    trained.setCertificationexpires(certificationexpires);
	    trainedInRepository.save(trained);

	    return trained;
	}

}
