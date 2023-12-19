package com.hospital.entities.id;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class UndergoesId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer patient;
	private Integer procedure;
	private Integer stay;
	private Timestamp date;

	public UndergoesId() {
	}

	public UndergoesId(Integer patient, Integer procedure, Integer stay, Timestamp date) {
		super();
		this.patient = patient;
		this.procedure = procedure;
		this.stay = stay;
		this.date = date;
	}

	public Integer getPatient() {
		return patient;
	}

	public void setPatient(Integer patient) {
		this.patient = patient;
	}

	public Integer getProcedure() {
		return procedure;
	}

	public void setProcedure(Integer procedure) {
		this.procedure = procedure;
	}

	public Integer getStay() {
		return stay;
	}

	public void setStay(Integer stay) {
		this.stay = stay;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, patient, procedure, stay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UndergoesId other = (UndergoesId) obj;
		return Objects.equals(date, other.date) && Objects.equals(patient, other.patient)
				&& Objects.equals(procedure, other.procedure) && Objects.equals(stay, other.stay);
	}

	public String toString() {
		return "UndergoesId [patient=" + patient + ", procedure=" + procedure + ", stay=" + stay + ", date=" + date
				+ "]";
	}

}
