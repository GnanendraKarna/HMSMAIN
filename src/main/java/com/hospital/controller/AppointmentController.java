package com.hospital.controller;
 
import java.sql.Timestamp;
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
 
import com.hospital.entities.Appointment;
import com.hospital.entities.Nurse;
import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.entities.Room;
import com.hospital.services.AppointmentService;
 

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins="http://localhost:4200/")
public class AppointmentController {
 
	@Autowired
	private AppointmentService appointmentService;
 
	@PostMapping
	public ResponseEntity<String> addAppointment(@Valid @RequestBody Appointment appointment) {
		Appointment isAppointmentCreated = appointmentService.addAppointment(appointment);
		if (isAppointmentCreated != null) {
			return new ResponseEntity<String>("Record Created Successfully",HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
 
	//Get a list of appointment
	@GetMapping
	public ResponseEntity<List<Appointment>> getAllAppointments(){
		List<Appointment> appointmentList=appointmentService.getAllAppointments();
		return new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.OK);
	}
	@GetMapping("/{startdate}")
	public ResponseEntity<List<Appointment>> getAllPatientsByPhysicianId(@PathVariable("startdate")Timestamp startdate){
		List<Appointment> appointmentList=appointmentService.getAppointmentsByStartDate(startdate);
		return new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.OK);
	}
	@GetMapping("/patient/{appointmentid}")
	public ResponseEntity<Patient> getPatientByAppointmentId(@PathVariable("appointmentid")int appointmentid){
		Patient patient=appointmentService.getPatientByAppointmentId(appointmentid);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	@GetMapping("/physician/{appointmentid}")
	public ResponseEntity<Physician> getPhysicianByAppointmentId(@PathVariable("appointmentid")int appointmentid){
		Physician physician=appointmentService.getPhysicianByAppointmentId(appointmentid);
		return new ResponseEntity<Physician>(physician,HttpStatus.OK);
	}
	@GetMapping("/nurse/{appointmentid}")
	public ResponseEntity<Nurse> getNurseByAppointmentId(@PathVariable("appointmentid")int appointmentid){
		Nurse nurse=appointmentService.getNurseByAppointmentId(appointmentid);
		return new ResponseEntity<Nurse>(nurse,HttpStatus.OK);
	}
	@GetMapping("/examinationroom/{appointmentid}")
	public ResponseEntity<String> getExaminationRoomByAppointmentId(@PathVariable("appointmentid")int appointmentid){
		String nurse=appointmentService.getExaminationroomByAppointmentId(appointmentid);
		return new ResponseEntity<String>(nurse,HttpStatus.OK);
	}
	@GetMapping("/physicianlist/{patientid}")
	public ResponseEntity<List<Physician>> getPhysicansByPatientId(@PathVariable("patientid")int patientid){
		List<Physician> physicianList =appointmentService.getPhysiciansByPatientId(patientid);
		return new ResponseEntity<List<Physician>>(physicianList,HttpStatus.OK);
	}
	@GetMapping("/physician/{patientid}/{date}")
	public ResponseEntity<Physician> getPhysicanByPatientIdOnDate(@PathVariable("patientid")int patientid,@PathVariable("date")Timestamp date){
		Physician physician =appointmentService.getPhysicianDetailByPatientIdOnDate(date,patientid);
		return new ResponseEntity<Physician>(physician,HttpStatus.OK);
	}
	@GetMapping("/nurselist/{patientid}")
	public ResponseEntity<List<Nurse>> getNurseListByPatientId(@PathVariable("patientid")int patientid){
		List<Nurse> nurseList =appointmentService.getAllNurseByPatientId(patientid);
		return new ResponseEntity<List<Nurse>>(nurseList,HttpStatus.OK);
	}
	@GetMapping("/nurse/{patientid}/{date}")
	public ResponseEntity<Nurse> getNurseByPatientOnDate(@PathVariable("patientid")int patientid,@PathVariable("date")Timestamp date){
		Nurse nurse =appointmentService.getNurseBypatientIdOnDate(date,patientid);
		return new ResponseEntity<Nurse>(nurse,HttpStatus.OK);
	}
	@GetMapping("/date/{patientid}")
	public ResponseEntity<List<Timestamp>> getAppointmentDatesbyPatientId(@PathVariable("patientid")int patientid){
		List<Timestamp> appointments =appointmentService.listOfAppointmentDatesByPatientId(patientid);
		return new ResponseEntity<List<Timestamp>>(appointments,HttpStatus.OK);
	}
	@GetMapping("/patientlist/physician/{physicianid}")
	public ResponseEntity<List<Patient>> getPatientsListByPhysician(@PathVariable("physicianid")int physicianid){
		List<Patient> patientsList =appointmentService.listOfPatientsByPhysicianId(physicianid);
		return new ResponseEntity<List<Patient>>(patientsList,HttpStatus.OK);
	}
	@GetMapping("/patientlist/{physicianid}/{date}")
	public ResponseEntity<List<Patient>> getPatientsListByPhysicianOnDate(@PathVariable("physicianid")int physicianid,@PathVariable("date")Timestamp date){
		List<Patient> patientsList =appointmentService.listOfPatientsByPhysicianIdOnDate(physicianid,date);
		return new ResponseEntity<List<Patient>>(patientsList,HttpStatus.OK);
	}
	@GetMapping("/patient/{physicianid}/{patientid}")
	public ResponseEntity<Patient> getPatientByPhysicianIdAndPatientId(@PathVariable("physicianid")int physicianid,@PathVariable("patientid")int patientid){
		Patient patient =appointmentService.getPatientByPatientIdAndPhysicianId(physicianid,patientid);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	@GetMapping("/patientlist/nurse/{nurseid}")
	public ResponseEntity<List<Patient>> getPatientsListBynurseId(@PathVariable("nurseid")int nurseid){
		List<Patient> patientsList =appointmentService.getListOfPatientsCheckedByNurse(nurseid);
		return new ResponseEntity<List<Patient>>(patientsList,HttpStatus.OK);
	}
	@GetMapping("/getpatient/{nurseid}/{patientid}")
	public ResponseEntity<Patient> getpatientBynurseIdAndPatientId(@PathVariable("nurseid")int nurseid, @PathVariable("patientid")int patientid){
		Patient patient =appointmentService.getPatientBynurseIdAndPatientId(nurseid,patientid);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	@GetMapping("/patientbynurse/{nurseid}/{date}")
	public ResponseEntity<List<Patient>> getPatientsListBynurseIdOnDate(@PathVariable("nurseid")int nurseid, @PathVariable("date")Timestamp date){
		List<Patient> patientList =appointmentService.getPatientBynurseIdOnDate(nurseid,date);
		return new ResponseEntity<List<Patient>>(patientList,HttpStatus.OK);
	}
	@GetMapping("/room/{patinetid}/{date}")
	public ResponseEntity<Room> getRoomDetailsByPatientIdOnDate(@PathVariable("patinetid")int patinetid, @PathVariable("date")Timestamp date){
		Room room =appointmentService.getRoomDetailsBypatientIdOnDate(patinetid,date);
		return new ResponseEntity<Room>(room,HttpStatus.OK);
	}

	@GetMapping("/physician/room/{physicianid}/{date}")
	public ResponseEntity<List<Room>> getRoomListByPhysicianIdOnDate(@PathVariable("physicianid")int physicianid, @PathVariable("date")Timestamp date){
		List<Room> roomList =appointmentService.getRoomListByPhysicianIdOnDate(physicianid,date);
		return new ResponseEntity<List<Room>>(roomList,HttpStatus.OK);
	}
	@GetMapping("/nurse/room/{nurseid}/{date}")
	public ResponseEntity<List<Room>> getRoomListByNurseIdOnDate(@PathVariable("nurseid")int nurseid, @PathVariable("date")Timestamp date){
		List<Room> roomList =appointmentService.getRoomListByNurseIdOnDate(nurseid,date);
		return new ResponseEntity<List<Room>>(roomList,HttpStatus.OK);
	}
	@PutMapping("/room/{appointmentid}")
	public ResponseEntity<Room> updateExaminationRoomByAppointmentId(@RequestBody Appointment appointment,@PathVariable("appointmentid")int appointmentid){
		Boolean isUpdated =appointmentService.updateExaminationRoomByAppointmentId(appointment.getExaminationroom(),appointmentid);
			if(isUpdated) {
				return new ResponseEntity<Room>(HttpStatus.CREATED);
			}
			return new ResponseEntity<Room>(HttpStatus.BAD_REQUEST);	
	}
 
}