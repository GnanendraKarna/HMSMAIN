package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
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
@Table(name = "department")
public class Department implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "departmentid")
	@NotNull
	private Integer departmentid;

	@Column(name = "name")
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 30, message = "Name cannot be longer than 30 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must only contain letters and spaces")
	private String name;

	@Column(name = "head")
	@NotNull
	private Integer head;

	// Mapping
	@OneToMany(mappedBy = "department2")
	@JsonIgnore
	private List<AffiliatedWith> listOfAffiliatedWith;

	@ManyToOne
	@JoinColumn(name = "head", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonIgnore
	private Physician physician;

	public Department() {
		super();
	}

	public Department(Integer departmentid, String name, Integer head) {
		super();
		this.departmentid = departmentid;
		this.name = name;
		this.head = head;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getDepartmentid() {
		return this.departmentid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setHead(Integer head) {
		this.head = head;
	}

	public Integer getHead() {
		return this.head;
	}

	public List<AffiliatedWith> getListOfAffiliatedWith() {
		return this.listOfAffiliatedWith;
	}

	public Physician getPhysician() {
		return this.physician;
	}

	public void setListOfAffiliatedWith(List<AffiliatedWith> listOfAffiliatedWith) {
		this.listOfAffiliatedWith = listOfAffiliatedWith;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public String toString() {
		return "Department [departmentid=" + departmentid + ", name=" + name + ", head=" + head + "]";
	}

}
