package com.hospital.entities.id;

import java.io.Serializable;
import java.util.Objects;
 
public class AffiliatedWithId implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private Integer physician;
	private Integer department;
 
	public AffiliatedWithId() {
	}
 
	public AffiliatedWithId(Integer physician, Integer department) {
		super();
		this.physician = physician;
		this.department = department;
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
 
	@Override
	public int hashCode() {
		return Objects.hash(department, physician);
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedWithId other = (AffiliatedWithId) obj;
		return Objects.equals(department, other.department) && Objects.equals(physician, other.physician);
	}
 
	public String toString() {
		return "AffiliatedWithId [physician=" + physician + ", department=" + department + "]";
	}
 
}

