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
 
import com.hospital.entities.Nurse;
import com.hospital.services.NurseService;
 

@RestController
@RequestMapping("/api/nurse")
@CrossOrigin(origins="http://localhost:4200/")
public class NurseController {
 
	@Autowired
	private NurseService service;
 
	@PostMapping
	public ResponseEntity<Nurse> saveNurse(@Valid @RequestBody Nurse nurse) {
	    service.registerNurse(nurse);
	    return new ResponseEntity<>(nurse, HttpStatus.CREATED);
	}

 


	
	@GetMapping
	public ResponseEntity<List<Nurse>> getNurse() {
		List<Nurse> nurses = service.getAll();
		return new ResponseEntity<List<Nurse>>(nurses, HttpStatus.OK);
	}
 
	@GetMapping("/{empid}")
	public ResponseEntity<Nurse> getNurseById(@PathVariable Integer empid) {
		Nurse nurse = service.getById(empid);
		if (nurse != null) {
			return new ResponseEntity<Nurse>(nurse, HttpStatus.OK);
		} else {
			return null;
		}
	}
 
	@GetMapping("/position/{empid}")
	public ResponseEntity<String> getPositionBy(@PathVariable Integer empid) {
		String position = service.getPositionBy(empid);
		if (position != null) {
			return new ResponseEntity<String>(position, HttpStatus.OK);
 
		} else {
			return null;
		}
	}
	@GetMapping("/registered/{empid}")
	public ResponseEntity<Boolean> getRegisteredBy(@PathVariable Integer empid) {
		Boolean register = service.getRegisteredBy(empid);
		return new ResponseEntity<Boolean>(register, HttpStatus.OK);
	}
 
	@PutMapping("/registered/{empid}")
	public ResponseEntity<Nurse> updateRegisteredBy(@Valid @PathVariable Integer empid,
			@RequestBody Nurse nurse) {
		Nurse nurse1 = service.getById(empid);
		if (nurse1 != null) {
			Nurse nurse2 = service.updateRegisteredBy(empid, nurse.getRegistered());
			return new ResponseEntity<Nurse>(nurse2, HttpStatus.OK);
		} else {
			return null;
		}
	}
 
	@PutMapping("/ssn/{empid}")
	public ResponseEntity<Nurse> updateSsnBy(@Valid @PathVariable Integer empid, @RequestBody Nurse nurse) {
		Nurse n = service.getById(empid);
		if (n != null) {
			Nurse nurse1 = service.updateSsnBy(empid, nurse.getSsn());
			return new ResponseEntity<Nurse>(nurse1, HttpStatus.OK);
		} else {
			return null;
 
		}
 
	}
	@GetMapping("/byname/{name}")
    public ResponseEntity<Nurse> getNurseByName(@PathVariable String name) {
        Nurse nurse = service.getByName(name);

        if (nurse != null) {
            return new ResponseEntity<>(nurse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 
}