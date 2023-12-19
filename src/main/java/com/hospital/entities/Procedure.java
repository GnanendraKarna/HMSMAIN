package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "procedures")
public class Procedure implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code")
	@NotNull
	private Integer code;

	@Column(name = "name")
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 30, message = "Name cannot be longer than 30 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must only contain letters and spaces")
	private String name;

	@Column(name = "cost")
	@NotNull
	private Double cost;

	// Mapping
	@OneToMany(mappedBy = "procedure")
	@JsonIgnore
	private List<TrainedIn> listofTrainedIn;

	@OneToMany(mappedBy = "procedure")
	@JsonIgnore
	private List<Undergoes> listOfUndergoes;

	public Procedure() {
		super();
	}

	public Procedure(Integer code, String name, Double cost) {
		super();
		this.code = code;
		this.name = name;
		this.cost = cost;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public List<TrainedIn> getListofTrainedIn() {
		return listofTrainedIn;
	}

	public void setListofTrainedIn(List<TrainedIn> listofTrainedIn) {
		this.listofTrainedIn = listofTrainedIn;
	}

	public List<Undergoes> getListOfUndergoes() {
		return listOfUndergoes;
	}

	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
		this.listOfUndergoes = listOfUndergoes;
	}

	public String toString() {
		return "Procedure [code=" + code + ", name=" + name + ", cost=" + cost + "]";
	}

}
