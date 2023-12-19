package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospital.entities.id.BlockId;


@Entity
@Table(name = "block")
@IdClass(BlockId.class)
public class Block implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "blockfloor", nullable = false)
	private Integer blockfloor;

	@Id
	@Column(name = "blockcode", nullable = false)
	private Integer blockcode;

	// Mapping
	@OneToMany(mappedBy = "block")
	@JsonManagedReference
	private List<OnCall> listOfOnCall;

	@OneToMany(mappedBy = "block")
	@JsonManagedReference
	private List<Room> listOfRoom;

	public Block() {
		super();
	}

	public Block(Integer blockfloor, Integer blockcode) {
		super();
		this.blockfloor = blockfloor;
		this.blockcode = blockcode;
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

	public List<OnCall> getListOfOnCall() {
		return this.listOfOnCall;
	}

	public List<Room> getListOfRoom() {
		return this.listOfRoom;
	}

	public void setListOfOnCall(List<OnCall> listOfOnCall) {
		this.listOfOnCall = listOfOnCall;
	}

	public void setListOfRoom(List<Room> listOfRoom) {
		this.listOfRoom = listOfRoom;
	}

	public String toString() {
		return "Block [blockfloor=" + blockfloor + ", blockcode=" + blockcode + "]";
	}

}
