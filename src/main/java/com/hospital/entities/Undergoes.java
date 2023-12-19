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
import com.hospital.entities.id.UndergoesId;

@Entity
@Table(name = "undergoes")
@IdClass(UndergoesId.class)
public class Undergoes implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "patient", nullable = false)
	private Integer patient;

	@Id
	@Column(name = "procedures", nullable = false)
	private Integer procedure;

	@Id
	@Column(name = "stay", nullable = false)
	private Integer stay;

	@Id
	@Column(name = "dateundergoes", nullable = false)
	private Timestamp date;

	@Column(name = "physician", nullable = false)
	private Integer physician;

	@Column(name = "assistingnurse")
	private Integer assistingnurse;

	// Mapping
	@ManyToOne
	@JoinColumn(name = "assistingnurse", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonIgnore
	private Nurse nurse;

	@ManyToOne
	@JoinColumn(name = "stay", referencedColumnName = "stayid", insertable = false, updatable = false)
	@JsonIgnore
	private Stay stay2;

	@ManyToOne
	@JoinColumn(name = "physician", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonIgnore
	private Physician physician2;

	@ManyToOne
	@JoinColumn(name = "procedure", referencedColumnName = "code", insertable = false, updatable = false)
	@JsonIgnore
	private Procedure procedure2;

	@ManyToOne
	@JoinColumn(name = "patient", referencedColumnName = "ssn", insertable = false, updatable = false)
	@JsonIgnore
	private Patient patient2;

	public Undergoes() {
		super();
	}

	public Undergoes(Integer patient, Integer procedure, Integer stay, Timestamp date, Integer physician,
			Integer assistingnurse) {
		super();
		this.patient = patient;
		this.procedure = procedure;
		this.stay = stay;
		this.date = date;
		this.physician = physician;
		this.assistingnurse = assistingnurse;
	}

	public void setPatient(Integer patient) {
		this.patient = patient;
	}

	public Integer getPatient() {
		return this.patient;
	}

	public void setProcedure(Integer procedure) {
		this.procedure = procedure;
	}

	public Integer getProcedure() {
		return this.procedure;
	}

	public void setStay(Integer stay) {
		this.stay = stay;
	}

	public Integer getStay() {
		return this.stay;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Integer getPhysician() {
		return this.physician;
	}

	public void setAssistingnurse(Integer assistingnurse) {
		this.assistingnurse = assistingnurse;
	}

	public Integer getAssistingnurse() {
		return this.assistingnurse;
	}

	public Nurse getNurse() {
		return this.nurse;
	}

	public Stay getStay2() {
		return this.stay2;
	}

	public Physician getPhysician2() {
		return this.physician2;
	}

	public Procedure getProcedure2() {
		return this.procedure2;
	}

	public Patient getPatient2() {
		return this.patient2;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public void setStay2(Stay stay2) {
		this.stay2 = stay2;
	}

	public void setPhysician2(Physician physician2) {
		this.physician2 = physician2;
	}

	public void setProcedure2(Procedure procedure2) {
		this.procedure2 = procedure2;
	}

	public void setPatient2(Patient patient2) {
		this.patient2 = patient2;
	}

	public String toString() {
		return "Undergoes [patient=" + patient + ", procedure=" + procedure + ", stay=" + stay + ", date=" + date
				+ ", physician=" + physician + ", assistingnurse=" + assistingnurse + "]";
	}

}
