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
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entities.AffiliatedWith;
import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.services.AffiliatedWithService;

@Validated
@RestController
@RequestMapping("api/affiliated_with")
@CrossOrigin(origins="http://localhost:4200/")
public class AffiliatedWithController {

	@Autowired
	private AffiliatedWithService service;

	// running
	@PostMapping("/post") // http://localhost:9090/api/affiliated_with/post
	public ResponseEntity<String> add(@Valid @RequestBody AffiliatedWith affiliatedWith) {
		service.add(affiliatedWith);
		return new ResponseEntity<String>("Record Created Successfully", HttpStatus.CREATED);
	}

	// running
	@GetMapping("/physicians/{deptid}") // http://localhost:9090/api/affiliated_with/physicians/{deptid}
	public ResponseEntity<List<Physician>> getPhysicianByDept(@PathVariable Integer deptid) {
		List<Physician> physician = service.getPhysicianByDepartment(deptid);
		
			return new ResponseEntity<List<Physician>>(physician, HttpStatus.OK);
	}
	
	// running
	@GetMapping("/department/{physicianid}") // http://localhost:9090/api/ affiliated_with /department/{physicianid}
	public ResponseEntity<List<Department>> getDepartmentByPhysician(@PathVariable Integer physicianid) {
		List<Department> department = service.getDepartmentByPhysician(physicianid);
		
			return new ResponseEntity<List<Department>>(department, HttpStatus.OK);
	}

	// running
	@GetMapping("/countphysician/{deptid}") // http://localhost:9090/api/affiliated_with /countphysician/{deptid}
	public ResponseEntity<Integer> getPhysicianCount(@PathVariable Integer deptid) {
		Integer physician = service.getByPhysicianId(deptid);
		return new ResponseEntity<Integer>(physician, HttpStatus.OK);
	}

	// running for unique value
	@GetMapping("/primary/{physicianid}") // http://localhost:9090/api/affiliated_with/primary/{physicianid}
	public ResponseEntity<Boolean> getPrimaryAffiliationByPhysician(@PathVariable Integer physicianid) {
		boolean primaryAffiliation = service.getPrimaryAffiliationByPhysician(physicianid);
		return new ResponseEntity<Boolean>(primaryAffiliation, HttpStatus.FOUND);
	}

	// running
	@PutMapping("/primary/{physicianid}/{primaryAffiliation}") // http://localhost:9090/api/affiliated_with/primary/{physicianid}/{pa}
	public ResponseEntity<Boolean> updatePrimaryAffiliation(@PathVariable Integer physicianid,
			@PathVariable boolean primaryAffiliation) {
		boolean primaryAffiliation1= service.updatePrimaryAffiliation(physicianid, primaryAffiliation);
		return new ResponseEntity<Boolean>(primaryAffiliation1, HttpStatus.FOUND);
	}

}
