package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "room")
public class Room implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "roomnumber", nullable = false)
	private Integer roomnumber;

	@Column(name = "roomtype", nullable = false, length = 30)
	private String roomtype;

	@Column(name = "blockfloor", nullable = false)
	private Integer blockfloor;

	@Column(name = "blockcode", nullable = false)
	private Integer blockcode;

	@Column(name = "unavailable", nullable = false)
	private Boolean unavailable;

	// Mapping
	@OneToMany(mappedBy = "room2")
//	@JsonIgnore
	@JsonBackReference
	private List<Stay> listOfStay;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "blockfloor", referencedColumnName = "blockfloor", insertable = false, updatable = false),
			@JoinColumn(name = "blockcode", referencedColumnName = "blockcode", insertable = false, updatable = false) })
	@JsonBackReference
	private Block block;

	public Room() {
		super();
	}

	public Room(Integer roomnumber, String roomtype, Integer blockfloor, Integer blockcode, Boolean unavailable) {
		super();
		this.roomnumber = roomnumber;
		this.roomtype = roomtype;
		this.blockfloor = blockfloor;
		this.blockcode = blockcode;
		this.unavailable = unavailable;
	}

	public void setRoomnumber(Integer roomnumber) {
		this.roomnumber = roomnumber;
	}

	public Integer getRoomnumber() {
		return this.roomnumber;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getRoomtype() {
		return this.roomtype;
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

	public void setUnavailable(Boolean unavailable) {
		this.unavailable = unavailable;
	}

	public Boolean getUnavailable() {
		return this.unavailable;
	}

	public List<Stay> getListOfStay() {
		return this.listOfStay;
	}

	public Block getBlock() {
		return this.block;
	}

	public void setListOfStay(List<Stay> listOfStay) {
		this.listOfStay = listOfStay;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public String toString() {
		return "Room [roomnumber=" + roomnumber + ", roomtype=" + roomtype + ", blockfloor=" + blockfloor
				+ ", blockcode=" + blockcode + ", unavailable=" + unavailable + "]";
	}

}
