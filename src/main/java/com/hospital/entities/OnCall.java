package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.entities.id.OnCallId;

@Entity
@Table(name = "on_call")
@IdClass(OnCallId.class)
public class OnCall implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nurse", nullable = false)
	private Integer nurse;

	@Id
	@Column(name = "blockfloor", nullable = false)
	private Integer blockfloor;

	@Id
	@Column(name = "blockcode", nullable = false)
	private Integer blockcode;

	@Id
	@Column(name = "oncallstart", nullable = false)
	private Timestamp oncallstart;

	@Id
	@Column(name = "oncallend", nullable = false)
	private Timestamp oncallend;

	// Mapping
	@ManyToOne
	@JoinColumn(name = "nurse", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonIgnore
	private Nurse nurse2;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "blockfloor", referencedColumnName = "blockfloor", insertable = false, updatable = false),
			@JoinColumn(name = "blockcode", referencedColumnName = "blockcode", insertable = false, updatable = false) })
	@JsonIgnore
	private Block block;

	public OnCall() {
		super();
	}

	public OnCall(Integer nurse, Integer blockfloor, Integer blockcode, Timestamp oncallstart, Timestamp oncallend) {
		super();
		this.nurse = nurse;
		this.blockfloor = blockfloor;
		this.blockcode = blockcode;
		this.oncallstart = oncallstart;
		this.oncallend = oncallend;
	}

	public void setNurse(Integer nurse) {
		this.nurse = nurse;
	}

	public Integer getNurse() {
		return this.nurse;
	}

	public void setBlockfloor(Integer blockfloor) {
		this.blockfloor = blockfloor;
	}

	public Integer getBlockfloor() {
		return this.blockfloor;
	}

	public void setBlockcode(Integer blockcode) {
		this.blockcode = blockcode;
	}

	public Integer getBlockcode() {
		return this.blockcode;
	}

	public void setOncallstart(Timestamp oncallstart) {
		this.oncallstart = oncallstart;
	}

	public Timestamp getOncallstart() {
		return this.oncallstart;
	}

	public void setOncallend(Timestamp oncallend) {
		this.oncallend = oncallend;
	}

	public Timestamp getOncallend() {
		return this.oncallend;
	}

	public Nurse getNurse2() {
		return this.nurse2;
	}

	public Block getBlock() {
		return this.block;
	}

	public void setNurse2(Nurse nurse2) {
		this.nurse2 = nurse2;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public String toString() {
		return "OnCall [nurse=" + nurse + ", blockfloor=" + blockfloor + ", blockcode=" + blockcode + ", oncallstart="
				+ oncallstart + ", oncallend=" + oncallend + "]";
	}

}
