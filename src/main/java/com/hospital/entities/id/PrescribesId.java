package com.hospital.entities.id;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class PrescribesId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer physician;
	private Integer patient;
	private Integer medication;
	private Timestamp date;

	public PrescribesId() {
	}

	public PrescribesId(Integer physician, Integer patient, Integer medication, Timestamp date) {
		super();
		this.physician = physician;
		this.patient = patient;
		this.medication = medication;
		this.date = date;
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

	@Override
	public int hashCode() {
		return Objects.hash(date, medication, patient, physician);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrescribesId other = (PrescribesId) obj;
		return Objects.equals(date, other.date) && Objects.equals(medication, other.medication)
				&& Objects.equals(patient, other.patient) && Objects.equals(physician, other.physician);
	}

	public String toString() {
		return "PrescribesId [physician=" + physician + ", patient=" + patient + ", medication=" + medication
				+ ", date=" + date + "]";
	}

}
