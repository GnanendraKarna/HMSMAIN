package com.hospital.entities.id;

import java.io.Serializable;
import java.util.Objects;

public class TrainedInId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer physician;
	private Integer treatment;

	public TrainedInId() {
	}

	public TrainedInId(Integer physician, Integer treatment) {
		super();
		this.physician = physician;
		this.treatment = treatment;
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

	@Override
	public int hashCode() {
		return Objects.hash(physician, treatment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainedInId other = (TrainedInId) obj;
		return Objects.equals(physician, other.physician) && Objects.equals(treatment, other.treatment);
	}

	public String toString() {
		return "TrainedInId [physician=" + physician + ", treatment=" + treatment + "]";
	}

}
