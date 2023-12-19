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

import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.entities.TrainedIn;
import com.hospital.exceptions.handler.PatientNotFoundException;
import com.hospital.services.DepartmentService;


@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins="http://localhost:4200/")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	// running
	@PostMapping 
	public ResponseEntity<String> addDepartment(@Valid @RequestBody Department department) {
		service.addDepartment(department);
		return new ResponseEntity<String>("Record Created Successfully", HttpStatus.CREATED);
	}

	// running
	@GetMapping 
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> department = service.getAllDepartments();
		return new ResponseEntity<List<Department>>(department, HttpStatus.OK);

	}

	// running
	@GetMapping("/{id}") 
	public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
		Department department = service.getById(id);
		if (department != null) {
			return new ResponseEntity<Department>(department, HttpStatus.OK);
		} else {
			throw new PatientNotFoundException("Department not found");
		}
	}

	// running
	@GetMapping("/head/{id}") 
	public ResponseEntity<Physician> getHeadOfDepartmentById(@PathVariable Integer id) {
		Physician physician = service.getHeadById(id);
		if (physician != null) {
			return new ResponseEntity<Physician>(physician, HttpStatus.OK);
		} else {
			throw new PatientNotFoundException("Heads not found");
		}
	}

	// running
	@GetMapping("/headcertification/{deptid}") 
	public ResponseEntity<List<TrainedIn>> getCertificationByHeadId(@PathVariable Integer deptid) {
		List<TrainedIn> trainedIn = service.getCertificationByDepartmentId(deptid);
			return new ResponseEntity<List<TrainedIn>>(trainedIn, HttpStatus.FOUND);
	}

	// running
	@GetMapping("/get/{head}") // http://localhost:9090/api/department/get/{head}
	public ResponseEntity<List<Department>> getDepartmentByHead(@PathVariable Integer head) {
		List<Department> department = service.getDepartmentByHead(head);
		return new ResponseEntity<List<Department>>(department, HttpStatus.FOUND);
	}

	// running
	@PutMapping("update/headid/{deptid}") 
	public ResponseEntity<Department> updateHeadBy(@PathVariable Integer deptid,
			@RequestBody Department department) {
		Department dept = service.updateHeadBy(deptid, department.getHead());
		return new ResponseEntity<Department>(dept, HttpStatus.OK);

	}

	// running
	@PutMapping("/update/deptname/{deptid}") 
	public ResponseEntity<Department> updateName(@PathVariable Integer deptid,
			@RequestBody Department department) {
		Department dept = service.updateName(deptid, department.getName());
		return new ResponseEntity<Department>(dept, HttpStatus.OK);
	}
	
	@GetMapping("/check/{physicianid}") 
	 public ResponseEntity<Boolean> checkPhysicianHead(@PathVariable Integer physicianid) {
		 boolean isHead = service.isPhysicianHead(physicianid);
	     return new ResponseEntity<>(isHead, HttpStatus.OK);
	     }
}
