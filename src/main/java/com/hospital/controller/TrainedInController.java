package com.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entities.Physician;
import com.hospital.entities.Procedure;
import com.hospital.entities.TrainedIn;
import com.hospital.services.TrainedInService;


@RestController
@RequestMapping("/api/trained_in")
@CrossOrigin(origins="http://localhost:4200/")
public class TrainedInController {

	@Autowired
	private TrainedInService service;
	
	
	@PostMapping("")
    public ResponseEntity<String> addCertification(@Valid @RequestBody TrainedIn trainedIn) {

        if (trainedIn == null) {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
        boolean success = service.addCertificate(trainedIn);
 
        if (success) {
            return new ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	// running
	@GetMapping
	public ResponseEntity<List<TrainedIn>> getWithCertification() {
		List<TrainedIn> certificate = service.getProcedureByCertification();
		return new ResponseEntity<List<TrainedIn>>(certificate, HttpStatus.OK);

	}

	// running
	@GetMapping("/treatment/physicianid")
	public ResponseEntity<List<Procedure>> getTreatmentForPhysician(@RequestParam("id") Integer physicianId) {
	    List<Procedure> proceduresForPhysician = service.getTreatment(physicianId);
	        return new ResponseEntity<>(proceduresForPhysician, HttpStatus.OK);
	}

	// running
	@GetMapping("/physician/{procedureid}")
	public ResponseEntity<List<Physician>> getPhysician(@PathVariable Integer procedureid) {
		List<Physician> list = service.getPhysicican(procedureid);
		return new ResponseEntity<List<Physician>>(list, HttpStatus.OK);
	}

	@PutMapping("/certificationexpiry/{physicianid}/{procedureid}")
	public ResponseEntity<TrainedIn> updatePhysicianAndProcedure(@PathVariable Integer physicianid,
			@PathVariable Integer procedureid, @RequestBody TrainedIn trainedin) {
		TrainedIn trained1 = service.updateCertificationExpires(physicianid, procedureid,
				trainedin.getCertificationexpires());
		return new ResponseEntity<TrainedIn>(trained1, HttpStatus.OK);

	}
}
