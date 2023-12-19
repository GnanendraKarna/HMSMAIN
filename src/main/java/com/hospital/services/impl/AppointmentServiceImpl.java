package com.hospital.services.impl;

import java.sql.Timestamp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entities.Appointment;
import com.hospital.entities.Nurse;
import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.entities.Room;
import com.hospital.exceptions.handler.AppointmentNotFoundException;
import com.hospital.repositories.AppointmentRepository;
import com.hospital.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment addAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
 
	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}
 
	@Override
    public List<Appointment> getAppointmentsByStartDate(Timestamp startdate) {
        List<Appointment> appointments = appointmentRepository.getAppointmentsByStartDate(startdate);
        if (appointments.isEmpty()) {
            throw new AppointmentNotFoundException("No appointments found for the given start date: " + startdate);
        }
        return appointments;
    }

    @Override
    public Patient getPatientByAppointmentId(int appointmentId) {
        Patient patient = appointmentRepository.getPatientDetailByAppointmentId(appointmentId);
        if (patient == null) {
            throw new AppointmentNotFoundException("Patient not found for appointmentId: " + appointmentId);
        }
        return patient;
    }

    @Override
    public Physician getPhysicianByAppointmentId(int appointmentId) {
        Physician physician = appointmentRepository.getPhysicianDetailByAppointmentId(appointmentId);
        if (physician == null) {
            throw new AppointmentNotFoundException("Physician not found for appointmentId: " + appointmentId);
        }
        return physician;
    }

    @Override
    public Nurse getNurseByAppointmentId(int appointmentId) {
        Nurse nurse = appointmentRepository.getNurseDetailByAppointmentId(appointmentId);
        if (nurse == null) {
            throw new AppointmentNotFoundException("Nurse not found for appointmentId: " + appointmentId);
        }
        return nurse;
    }

    @Override
    public String getExaminationroomByAppointmentId(int appointmentId) {
        String examinationRoom = appointmentRepository.findExaminationRoomByAppointmentId(appointmentId);
        if (examinationRoom == null) {
            throw new AppointmentNotFoundException("Examination room not found for appointmentId: " + appointmentId);
        }
        return examinationRoom;
    }
 
    @Override
    public List<Physician> getPhysiciansByPatientId(int patientId) {
        List<Physician> physicians = appointmentRepository.findPhysiciansByPatientId(patientId);
        if (physicians.isEmpty()) {
            throw new AppointmentNotFoundException("No physicians found for patientId: " + patientId);
        }
        return physicians;
    }

    @Override
    public Physician getPhysicianDetailByPatientIdOnDate(Timestamp date, int patientId) {
        Physician physician = appointmentRepository.getPhysicianDetailByPatientIdOnDate(date, patientId);
        if (physician == null) {
            throw new AppointmentNotFoundException("Physician not found for patientId: " + patientId + " and date: " + date);
        }
        return physician;
    }

    @Override
    public List<Nurse> getAllNurseByPatientId(int patientId) {
        List<Nurse> nurses = appointmentRepository.getAllNurseByPatientId(patientId);
        if (nurses.isEmpty()) {
            throw new AppointmentNotFoundException("No nurses found for patientId: " + patientId);
        }
        return nurses;
    }

    @Override
    public Nurse getNurseBypatientIdOnDate(Timestamp date, int patientId) {
        Nurse nurse = appointmentRepository.getNurseBypatientIdOnDate(date, patientId);
        if (nurse == null) {
            throw new AppointmentNotFoundException("Nurse not found for patientId: " + patientId + " and date: " + date);
        }
        return nurse;
    }

    @Override
    public List<Timestamp> listOfAppointmentDatesByPatientId(int patientId) {
        List<Timestamp> appointmentDates = appointmentRepository.listOfAppointmentDatesByPatientId(patientId);
        if (appointmentDates.isEmpty()) {
            throw new AppointmentNotFoundException("No appointment dates found for patientId: " + patientId);
        }
        return appointmentDates;
    }

    @Override
    public List<Patient> listOfPatientsByPhysicianId(int physicianId) {
        List<Patient> patients = appointmentRepository.listOfPatientsByPhysicianId(physicianId);
        if (patients.isEmpty()) {
            throw new AppointmentNotFoundException("No patients found for physicianId: " + physicianId);
        }
        return patients;
    }
 
    @Override
    public List<Patient> listOfPatientsByPhysicianIdOnDate(int physicianId, Timestamp date) {
        List<Patient> patients = appointmentRepository.listOfPatientsByPhysicianIdOnDate(physicianId, date);
        if (patients.isEmpty()) {
            throw new AppointmentNotFoundException("No patients found for physicianId: " + physicianId + " and date: " + date);
        }
        return patients;
    }

    @Override
    public Patient getPatientByPatientIdAndPhysicianId(int physicianId, int patientId) {
        Patient patient = appointmentRepository.getPatientByPatientIdAndPhysicianId(physicianId, patientId);
        if (patient == null) {
            throw new AppointmentNotFoundException("Patient not found for physicianId: " + physicianId + " and patientId: " + patientId);
        }
        return patient;
    }

    @Override
    public List<Patient> getListOfPatientsCheckedByNurse(int nurseId) {
        List<Patient> patients = appointmentRepository.getListOfPatientsCheckedByNurse(nurseId);
        if (patients.isEmpty()) {
            throw new AppointmentNotFoundException("No patients found for nurseId: " + nurseId);
        }
        return patients;
    }

    @Override
    public Patient getPatientBynurseIdAndPatientId(int nurseId, int patientId) {
        Patient patient = appointmentRepository.getPatientBynurseIdAndPatientId(nurseId, patientId);
        if (patient == null) {
            throw new AppointmentNotFoundException("Patient not found for nurseId: " + nurseId + " and patientId: " + patientId);
        }
        return patient;
    }

    @Override
    public List<Patient> getPatientBynurseIdOnDate(int nurseId, Timestamp date) {
        List<Patient> patients = appointmentRepository.getPatientBynurseIdOnDate(nurseId, date);
        if (patients.isEmpty()) {
            throw new AppointmentNotFoundException("No patients found for nurseId: " + nurseId + " and date: " + date);
        }
        return patients;
    }
 
    @Override
    public Room getRoomDetailsBypatientIdOnDate(int patientId, Timestamp date) {
        Room room = appointmentRepository.getRoomDetailsBypatientIdOnDate(patientId, date);
        if (room == null) {
            throw new AppointmentNotFoundException("Room not found for patientId: " + patientId + " and date: " + date);
        }
        return room;
    }

    @Override
    public List<Room> getRoomListByPhysicianIdOnDate(int physicianId, Timestamp date) {
        List<Room> rooms = appointmentRepository.getRoomListByPhysicianIdOnDate(physicianId, date);
        if (rooms.isEmpty()) {
            throw new AppointmentNotFoundException("No rooms found for physicianId: " + physicianId + " and date: " + date);
        }
        return rooms;
    }

    @Override
    public List<Room> getRoomListByNurseIdOnDate(int nurseId, Timestamp date) {
        List<Room> rooms = appointmentRepository.getRoomListByNurseIdOnDate(nurseId, date);
        if (rooms.isEmpty()) {
            throw new AppointmentNotFoundException("No rooms found for nurseId: " + nurseId + " and date: " + date);
        }
        return rooms;
    }
 
	@Transactional
	 @Override
	    public Boolean updateExaminationRoomByAppointmentId(String newExaminationRoom, int appointmentId) {
	        Integer isUpdated = appointmentRepository.updateExaminationRoomByAppointmentId(newExaminationRoom, appointmentId);
	        if (isUpdated > 0) {
	            return true;
	        } else {
	            throw new AppointmentNotFoundException("Appointment not found for appointmentId: " + appointmentId);
	        }
	    }

}
