package com.hospital.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
public class Patient  {

	@Id
    @NotNull
    @Column(name = "ssn")
    private Integer ssn;
 
    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    @Column(name = "name")
    private String name;
 
    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Address must contain only letters, numbers, and spaces")
    @Column(name = "address")
    private String address;
 
    @NotBlank
    @Size(max = 30)
  //  @Pattern(regexp = "^[0-9]+$", message = "Phone must contain only numbers")
    @Column(name = "phone")
    private String phone;
 
    @NotNull
    @Column(name = "insuranceid")
    private Integer insuranceid;
 
    @NotNull
    @Column(name = "pcp")
    private Integer pcp;

	// Mapping
	@OneToMany(mappedBy = "patient2")
	@JsonIgnore
	private List<Prescribes> listOfPrescribes;

	@OneToMany(mappedBy = "patient2")
	@JsonIgnore
	private List<Undergoes> listOfUndergoes;

	@OneToMany(mappedBy = "patient2")
	@JsonIgnore
	private List<Appointment> listOfAppointment;

	@OneToMany(mappedBy = "patient2")
	@JsonIgnore
	private List<Stay> listOfStay;

	@ManyToOne
	@JoinColumn(name = "pcp", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonIgnore
	private Physician physician;


	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getInsuranceid() {
		return insuranceid;
	}

	public void setInsuranceid(Integer insuranceid) {
		this.insuranceid = insuranceid;
	}

	public Integer getPcp() {
		return pcp;
	}

	public void setPcp(Integer pcp) {
		this.pcp = pcp;
	}

	public List<Prescribes> getListOfPrescribes() {
		return listOfPrescribes;
	}

	public void setListOfPrescribes(List<Prescribes> listOfPrescribes) {
		this.listOfPrescribes = listOfPrescribes;
	}

	public List<Undergoes> getListOfUndergoes() {
		return listOfUndergoes;
	}

	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
		this.listOfUndergoes = listOfUndergoes;
	}

	public List<Appointment> getListOfAppointment() {
		return listOfAppointment;
	}

	public void setListOfAppointment(List<Appointment> listOfAppointment) {
		this.listOfAppointment = listOfAppointment;
	}

	public List<Stay> getListOfStay() {
		return listOfStay;
	}

	public void setListOfStay(List<Stay> listOfStay) {
		this.listOfStay = listOfStay;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}


}
