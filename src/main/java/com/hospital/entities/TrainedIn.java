package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.entities.id.TrainedInId;

@Entity
@Table(name = "trained_in")
@IdClass(TrainedInId.class)
public class TrainedIn implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "physician")
	@NotNull
	private Integer physician;

	@Id
	@Column(name = "treatment")
	@NotNull
	private Integer treatment;

	@Column(name = "certificationdate", nullable = false)
	private Date certificationdate;

	@Column(name = "certificationexpires", nullable = false)
	private Date certificationexpires;

	// Mapping
	@ManyToOne
	@JoinColumn(name = "treatment", referencedColumnName = "code", insertable = false, updatable = false)
	@JsonIgnore
	private Procedure procedure;

	@ManyToOne
	@JoinColumn(name = "physician", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonIgnore
	private Physician physician2;

	public TrainedIn() {
		super();
	}

	public TrainedIn(Integer physician, Integer treatment, Date certificationdate, Date certificationexpires) {
		super();
		this.physician = physician;
		this.treatment = treatment;
		this.certificationdate = certificationdate;
		this.certificationexpires = certificationexpires;
	}

	public Integer getPhysician() {
		return physician;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Integer getTreatment() {
		return treatment;
	}

	public void setTreatment(Integer treatment) {
		this.treatment = treatment;
	}

	public Date getCertificationdate() {
		return certificationdate;
	}

	public void setCertificationdate(Date certificationdate) {
		this.certificationdate = certificationdate;
	}

	public Date getCertificationexpires() {
		return certificationexpires;
	}

	public void setCertificationexpires(Date certificationexpires) {
		this.certificationexpires = certificationexpires;
	}

	public Procedure getProcedure() {
		return this.procedure;
	}

	public Physician getPhysician2() {
		return this.physician2;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public void setPhysician2(Physician physician2) {
		this.physician2 = physician2;
	}

	public String toString() {
		return "TrainedIn [physician=" + physician + ", treatment=" + treatment + ", certificationdate="
				+ certificationdate + ", certificationexpires=" + certificationexpires + "]";
	}

}
