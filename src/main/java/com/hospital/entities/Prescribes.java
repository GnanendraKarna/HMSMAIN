package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.entities.id.PrescribesId;

@Entity
@Table(name = "prescribes")
@IdClass(PrescribesId.class)
public class Prescribes implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "physician", nullable = false)
	private Integer physician;

	@Id
	@Column(name = "patient", nullable = false)
	private Integer patient;

	@Id
	@Column(name = "medication", nullable = false)
	private Integer medication;

	@Id
	@Column(name = "date", nullable = false)
	private Timestamp date;

	@Column(name = "appointment")
	private Integer appointment;

	@Column(name = "dose", nullable = false, length = 30)
	private String dose;

	// Mapping
	@ManyToOne
	@JoinColumn(name = "medication", referencedColumnName = "code", insertable = false, updatable = false)
	@JsonIgnore
	private Medication medication2;

	@ManyToOne
	@JoinColumn(name = "appointment", referencedColumnName = "appointmentid", insertable = false, updatable = false)
	@JsonIgnore
	private Appointment appointment2;

	@ManyToOne
	@JoinColumn(name = "patient", referencedColumnName = "ssn", insertable = false, updatable = false)
	@JsonIgnore
	private Patient patient2;

	@ManyToOne
	@JoinColumn(name = "physician", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonIgnore
	private Physician physician2;

	public Prescribes() {
		super();
	}

	public Prescribes(Integer physician, Integer patient, Integer medication, Timestamp date, Integer appointment,
			String dose) {
		super();
		this.physician = physician;
		this.patient = patient;
		this.medication = medication;
		this.date = date;
		this.appointment = appointment;
		this.dose = dose;
	}

	public Integer getPhysician() {
		return physician;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Integer getPatient() {
		return patient;
	}

	public void setPatient(Integer patient) {
		this.patient = patient;
	}

	public Integer getMedication() {
		return medication;
	}

	public void setMedication(Integer medication) {
		this.medication = medication;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getAppointment() {
		return appointment;
	}

	public void setAppointment(Integer appointment) {
		this.appointment = appointment;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public Medication getMedication2() {
		return medication2;
	}

	public void setMedication2(Medication medication2) {
		this.medication2 = medication2;
	}

	public Appointment getAppointment2() {
		return appointment2;
	}

	public void setAppointment2(Appointment appointment2) {
		this.appointment2 = appointment2;
	}

	public Patient getPatient2() {
		return patient2;
	}

	public void setPatient2(Patient patient2) {
		this.patient2 = patient2;
	}

	public Physician getPhysician2() {
		return physician2;
	}

	public void setPhysician2(Physician physician2) {
		this.physician2 = physician2;
	}

	public String toString() {
		return "Prescribes [physician=" + physician + ", patient=" + patient + ", medication=" + medication + ", date="
				+ date + ", appointment=" + appointment + ", dose=" + dose + "]";
	}

}
