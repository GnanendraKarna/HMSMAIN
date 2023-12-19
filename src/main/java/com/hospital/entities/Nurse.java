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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "nurse")
@SequenceGenerator(name = "nurseseq", sequenceName = "nurseseq")
public class Nurse implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeid", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nurseseq")
	private Integer employeeid;

	@Column(name = "name")
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 30, message = "Name cannot be longer than 30 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must only contain letters and spaces")
	private String name;

	@Column(name = "position")
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 30, message = "Name cannot be longer than 30 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "position must only contain letters and spaces")
	private String position;

	@Column(name = "registered", nullable = false)
	private Boolean registered;

	@Column(name = "ssn")
	@NotNull
	private Integer ssn;

	// Mapping
	@OneToMany(mappedBy = "nurse2")
	@JsonIgnore
	private List<OnCall> listOfOnCall;

	@OneToMany(mappedBy = "nurse")
	@JsonIgnore
	private List<Appointment> listOfAppointment;

	@OneToMany(mappedBy = "nurse")
	@JsonIgnore
	private List<Undergoes> listOfUndergoes;

	public Nurse() {
		super();
	}

	public Nurse(Integer employeeid, String name, String position, Boolean registered, Integer ssn) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.position = position;
		this.registered = registered;
		this.ssn = ssn;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getEmployeeid() {
		return this.employeeid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return this.position;
	}

	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}

	public Boolean getRegistered() {
		return this.registered;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Integer getSsn() {
		return this.ssn;
	}

	public List<OnCall> getListOfOnCall() {
		return this.listOfOnCall;
	}

	public List<Appointment> getListOfAppointment() {
		return this.listOfAppointment;
	}

	public List<Undergoes> getListOfUndergoes() {
		return this.listOfUndergoes;
	}

	public void setListOfOnCall(List<OnCall> listOfOnCall) {
		this.listOfOnCall = listOfOnCall;
	}

	public void setListOfAppointment(List<Appointment> listOfAppointment) {
		this.listOfAppointment = listOfAppointment;
	}

	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
		this.listOfUndergoes = listOfUndergoes;
	}

	public String toString() {
		return "Nurse [employeeid=" + employeeid + ", name=" + name + ", position=" + position + ", registered="
				+ registered + ", ssn=" + ssn + "]";
	}

}
