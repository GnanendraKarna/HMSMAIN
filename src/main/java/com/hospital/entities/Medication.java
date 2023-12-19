package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "medication")
public class Medication implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code", nullable = false)
	private Integer code;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "brand", nullable = false, length = 30)
	private String brand;

	@Column(name = "description", nullable = false, length = 30)
	private String description;

	// Mapping
	@OneToMany(mappedBy = "medication2")
	@JsonIgnore
	private List<Prescribes> listOfPrescribes;

	public Medication() {
		super();
	}

	public Medication(Integer code, String name, String brand, String description) {
		super();
		this.code = code;
		this.name = name;
		this.brand = brand;
		this.description = description;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public List<Prescribes> getListOfPrescribes() {
		return this.listOfPrescribes;
	}

	public void setListOfPrescribes(List<Prescribes> listOfPrescribes) {
		this.listOfPrescribes = listOfPrescribes;
	}

	public String toString() {
		return "Medication [code=" + code + ", name=" + name + ", brand=" + brand + ", description=" + description
				+ "]";
	}

}
