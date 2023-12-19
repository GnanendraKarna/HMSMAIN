package com.hospital.entities;
 
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {
 
	@Serial
	private static final long serialVersionUID = 1L;
 
	@Id
	 @NotNull(message = "appointmentid cannot be null")
	@Column(name = "appointmentid")
	private Integer appointmentid;
 
	@Column(name = "patient")
	@NotNull(message = "pateintid cannot be null")
	private Integer patient;
 
	@Column(name = "prepnurse")
	@NotNull(message = "nurseid cannot be null")
	private Integer prepnurse;
 
	@Column(name = "physician")
	@NotNull(message = "physicianid cannot be null")
	private Integer physician;
 
	@Column(name = "starto")
	private Timestamp startDateTime;
 
	@Column(name = "endo")
	private Timestamp endDateTime;
 
	@Column(name = "examinationroom")
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]$", message = "examinationroom must be a single alphabet")
	private String examinationroom;
 
	// Mapping
	@OneToMany(mappedBy = "appointment2")
	@JsonIgnore
	private List<Prescribes> listOfPrescribes;
 
	@ManyToOne
	@JoinColumn(name = "patient", referencedColumnName = "ssn", insertable = false, updatable = false)
	@JsonIgnore
	private Patient patient2;
 
	@ManyToOne
	@JoinColumn(name = "physician", referencedColumnName = "employeeid", insertable = false, updatable = false)
	
	private Physician physician2;
 
	@ManyToOne
	@JoinColumn(name = "prepnurse", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonIgnore
	private Nurse nurse;
 
	public Appointment() {
		super();
	}
 
	public Appointment(Integer appointmentid, Integer patient, Integer prepnurse, Integer physician,
			Timestamp startDateTime, Timestamp endDateTime, String examinationroom) {
		super();
		this.appointmentid = appointmentid;
		this.patient = patient;
		this.prepnurse = prepnurse;
		this.physician = physician;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.examinationroom = examinationroom;
	}
 
	public Integer getAppointmentid() {
		return appointmentid;
	}
 
	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}
 
	public Integer getPatient() {
		return patient;
	}
 
	public void setPatient(Integer patient) {
		this.patient = patient;
	}
 
	public Integer getPrepnurse() {
		return prepnurse;
	}
 
	public void setPrepnurse(Integer prepnurse) {
		this.prepnurse = prepnurse;
	}
 
	public Integer getPhysician() {
		return physician;
	}
 
	public void setPhysician(Integer physician) {
		this.physician = physician;
	}
 
	public Timestamp getStartDateTime() {
		return startDateTime;
	}
 
	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}
 
	public Timestamp getEndDateTime() {
		return endDateTime;
	}
 
	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}
 
	public String getExaminationroom() {
		return examinationroom;
	}
 
	public void setExaminationroom(String examinationroom) {
		this.examinationroom = examinationroom;
	}
 
	public List<Prescribes> getListOfPrescribes() {
		return this.listOfPrescribes;
	}
 
	public Patient getPatient2() {
		return this.patient2;
	}
 
	public Physician getPhysician2() {
		return this.physician2;
	}
 
	public Nurse getNurse() {
		return this.nurse;
	}
 
	public void setListOfPrescribes(List<Prescribes> listOfPrescribes) {
		this.listOfPrescribes = listOfPrescribes;
	}
 
	public void setPatient2(Patient patient2) {
		this.patient2 = patient2;
	}
 
	public void setPhysician2(Physician physician2) {
		this.physician2 = physician2;
	}
 
	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}
 
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", patient=" + patient + ", prepnurse=" + prepnurse
				+ ", physician=" + physician + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", examinationroom=" + examinationroom + "]";
	}
 
	public static Integer generateRandomNumber() {
		int length = 8;
        // Create an instance of the Random class
        Random random = new Random();
        // Generate a random number of the specified length
        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(9) + 1; // Generates a random number between 1 and 9
            randomNumber.append(digit);
        }
       return Integer.parseInt(randomNumber.toString());
	}
}