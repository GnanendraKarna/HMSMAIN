package com.hospital.services;

import java.sql.Timestamp;
import java.util.List;

import com.hospital.entities.Appointment;
import com.hospital.entities.Nurse;
import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.entities.Room;

public interface AppointmentService {

	public Appointment addAppointment(Appointment appointment);
	
	public List<Appointment> getAllAppointments();
	
	public List<Appointment> getAppointmentsByStartDate(Timestamp startdate);
	
	public Patient getPatientByAppointmentId(int appointmentId);
	
	public Physician getPhysicianByAppointmentId(int appointmentId);
	
	public Nurse getNurseByAppointmentId(int appointmentId);
	
	public String getExaminationroomByAppointmentId(int appointmentId);//
	
	public List<Physician> getPhysiciansByPatientId(int patientId);
	
	public Physician getPhysicianDetailByPatientIdOnDate(Timestamp date,int patientId);
	
	public List<Nurse> getAllNurseByPatientId(int patientId);
	
	public Nurse getNurseBypatientIdOnDate(Timestamp date,int patientId);
	
	public List<Timestamp> listOfAppointmentDatesByPatientId(int patientId);
	
	public List<Patient> listOfPatientsByPhysicianId(int physicianId);
	
	public List<Patient> listOfPatientsByPhysicianIdOnDate(int physicianId,Timestamp date);
	
	public Patient getPatientByPatientIdAndPhysicianId(int physicianId,int patientId);
	
	public List<Patient> getListOfPatientsCheckedByNurse(int nurseId);
	
	public Patient getPatientBynurseIdAndPatientId(int nurseId,int patientId);
	
	public List<Patient> getPatientBynurseIdOnDate(int nurseId,Timestamp date);
	
	public Room getRoomDetailsBypatientIdOnDate(int patientId,Timestamp date);
	
	public List<Room> getRoomListByPhysicianIdOnDate(int physicianId,Timestamp date);
	
	public List<Room> getRoomListByNurseIdOnDate(int nurseId,Timestamp date);
	
	public Boolean updateExaminationRoomByAppointmentId(String newExaminationRoom,int appointmentId);

	
}
