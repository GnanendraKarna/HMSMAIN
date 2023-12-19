package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.entities.id.AffiliatedWithId;

@Entity
@Table(name = "affiliated_with")
@IdClass(AffiliatedWithId.class)
public class AffiliatedWith implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "physician")
	@NotNull
	private Integer physician;

	@Id
	@Column(name = "department")
	@NotNull
	private Integer department;

	@Column(name = "primaryaffiliation", nullable = false)
	private Boolean primaryaffiliation;

	// Mapping
	@ManyToOne
	@JoinColumn(name = "physician", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonIgnore
	private Physician physician2;

	@ManyToOne
	@JoinColumn(name = "department", referencedColumnName = "departmentid", insertable = false, updatable = false)
	@JsonIgnore
	private Department department2;

	public AffiliatedWith() {
		super();
	}

	public AffiliatedWith(Integer physician, Integer department, Boolean primaryaffiliation) {
		super();
		this.physician = physician;
		this.department = department;
		this.primaryaffiliation = primaryaffiliation;
	}

	public Integer getPhysician() {
		return physician;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Boolean getPrimaryaffiliation() {
		return primaryaffiliation;
	}

	public void setPrimaryaffiliation(Boolean primaryaffiliation) {
		this.primaryaffiliation = primaryaffiliation;
	}

	public Physician getPhysician2() {
		return this.physician2;
	}

	public Department getDepartment2() {
		return this.department2;
	}

	public void setPhysician2(Physician physician2) {
		this.physician2 = physician2;
	}

	public void setDepartment2(Department department2) {
		this.department2 = department2;
	}

	public String toString() {
		return "AffiliatedWith [physician=" + physician + ", department=" + department + ", primaryaffiliation="
				+ primaryaffiliation + "]";
	}

}
