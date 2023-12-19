package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "physician")
public class Physician implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeid", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeid;

	@Column(name = "name")
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 30, message = "Name cannot be longer than 30 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must only contain letters and spaces")
	private String name;

	@Column(name = "position")
    @NotBlank(message = "Position cannot be blank")
    @Size(max = 30, message = "Position cannot be longer than 30 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "position must only contain letters and spaces")
	private String position;

	@Column(name = "ssn")
    @NotNull(message = "SSN cannot be null")
	@Digits(integer = 9, fraction = 0, message = "SSN must be a 9-digit number")
	private Integer ssn;

	// Mapping
	@OneToMany(mappedBy = "physician")
	@JsonIgnore
	private List<Department> listOfDepartment;

	@OneToMany(mappedBy = "physician2")
	@JsonIgnore
	private List<Undergoes> listOfUndergoes;

	@OneToMany(mappedBy = "physician2")
	@JsonIgnore
	private List<AffiliatedWith> listOfAffiliatedWith;

	@OneToMany(mappedBy = "physician2")
	@JsonIgnore
	private List<TrainedIn> listOfTrainedIn;

	@OneToMany(mappedBy = "physician2")
	@JsonIgnore
	private List<Prescribes> listOfPrescribes;

	@OneToMany(mappedBy = "physician")
	@JsonIgnore
	private List<Patient> listOfPatient;

	@OneToMany(mappedBy = "physician2")
	@JsonIgnore
	private List<Appointment> listOfAppointment;

	public Physician() {
		super();
	}

	public Physician(Integer employeeid, String name, String position, Integer ssn) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.position = position;
		this.ssn = ssn;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public List<Department> getListOfDepartment() {
		return listOfDepartment;
	}

	public void setListOfDepartment(List<Department> listOfDepartment) {
		this.listOfDepartment = listOfDepartment;
	}

	public List<Undergoes> getListOfUndergoes() {
		return listOfUndergoes;
	}

	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
		this.listOfUndergoes = listOfUndergoes;
	}

	public List<AffiliatedWith> getListOfAffiliatedWith() {
		return listOfAffiliatedWith;
	}

	public void setListOfAffiliatedWith(List<AffiliatedWith> listOfAffiliatedWith) {
		this.listOfAffiliatedWith = listOfAffiliatedWith;
	}

	public List<TrainedIn> getListOfTrainedIn() {
		return listOfTrainedIn;
	}

	public void setListOfTrainedIn(List<TrainedIn> listOfTrainedIn) {
		this.listOfTrainedIn = listOfTrainedIn;
	}

	public List<Prescribes> getListOfPrescribes() {
		return listOfPrescribes;
	}

	public void setListOfPrescribes(List<Prescribes> listOfPrescribes) {
		this.listOfPrescribes = listOfPrescribes;
	}

	public List<Patient> getListOfPatient() {
		return listOfPatient;
	}

	public void setListOfPatient(List<Patient> listOfPatient) {
		this.listOfPatient = listOfPatient;
	}

	public List<Appointment> getListOfAppointment() {
		return listOfAppointment;
	}

	public void setListOfAppointment(List<Appointment> listOfAppointment) {
		this.listOfAppointment = listOfAppointment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "Physician [employeeid=" + employeeid + ", name=" + name + ", position=" + position + ", ssn=" + ssn
				+ "]";
	}

}
