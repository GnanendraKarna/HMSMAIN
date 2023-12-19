package com.hospital.entities.id;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class OnCallId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer nurse;
	private Integer blockfloor;
	private Integer blockcode;
	private Timestamp oncallstart;
	private Timestamp oncallend;

	public OnCallId() {
	}

	public OnCallId(Integer nurse, Integer blockfloor, Integer blockcode, Timestamp oncallstart, Timestamp oncallend) {
		super();
		this.nurse = nurse;
		this.blockfloor = blockfloor;
		this.blockcode = blockcode;
		this.oncallstart = oncallstart;
		this.oncallend = oncallend;
	}

	public Integer getNurse() {
		return nurse;
	}

	public void setNurse(Integer nurse) {
		this.nurse = nurse;
	}

	public Integer getBlockfloor() {
		return blockfloor;
	}

	public void setBlockfloor(Integer blockfloor) {
		this.blockfloor = blockfloor;
	}

	public Integer getBlockcode() {
		return blockcode;
	}

	public void setBlockcode(Integer blockcode) {
		this.blockcode = blockcode;
	}

	public Timestamp getOncallstart() {
		return oncallstart;
	}

	public void setOncallstart(Timestamp oncallstart) {
		this.oncallstart = oncallstart;
	}

	public Timestamp getOncallend() {
		return oncallend;
	}

	public void setOncallend(Timestamp oncallend) {
		this.oncallend = oncallend;
	}

	@Override
	public int hashCode() {
		return Objects.hash(blockcode, blockfloor, nurse, oncallend, oncallstart);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OnCallId other = (OnCallId) obj;
		return Objects.equals(blockcode, other.blockcode) && Objects.equals(blockfloor, other.blockfloor)
				&& Objects.equals(nurse, other.nurse) && Objects.equals(oncallend, other.oncallend)
				&& Objects.equals(oncallstart, other.oncallstart);
	}

	public String toString() {
		return "OnCallId [nurse=" + nurse + ", blockfloor=" + blockfloor + ", blockcode=" + blockcode + ", oncallstart="
				+ oncallstart + ", oncallend=" + oncallend + "]";
	}

}
