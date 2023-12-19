package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "stay")
public class Stay implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "stayid", nullable = false)
	private Integer stayid;

	@Column(name = "patient", nullable = false)
	private Integer patient;

	@Column(name = "room", nullable = false)
	private Integer room;

	@Column(name = "staystart")
	private Timestamp startTime;

	@Column(name = "stayend")
	private Timestamp endTime;

	// Mapping
	@ManyToOne
	@JoinColumn(name = "room", referencedColumnName = "roomnumber", insertable = false, updatable = false)
	@JsonBackReference
	private Room room2;

	@ManyToOne
	@JoinColumn(name = "patient", referencedColumnName = "ssn", insertable = false, updatable = false)
	@JsonBackReference
	private Patient patient2;

	@OneToMany(mappedBy = "stay2")
	@JsonManagedReference
	private List<Undergoes> listOfUndergoes;

	public Stay() {
		super();
	}

	public Stay(Integer stayid, Integer patient, Integer room, Timestamp startTime, Timestamp endTime, Room room2,
			Patient patient2) {
		super();
		this.stayid = stayid;
		this.patient = patient;
		this.room = room;
		this.startTime = startTime;
		this.endTime = endTime;
		this.room2 = room2;
		this.patient2 = patient2;
	}

	public Integer getStayid() {
		return stayid;
	}

	public void setStayid(Integer stayid) {
		this.stayid = stayid;
	}

	public Integer getPatient() {
		return patient;
	}

	public void setPatient(Integer patient) {
		this.patient = patient;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Room getRoom2() {
		return room2;
	}

	public void setRoom2(Room room2) {
		this.room2 = room2;
	}

	public Patient getPatient2() {
		return patient2;
	}

	public void setPatient2(Patient patient2) {
		this.patient2 = patient2;
	}

	public List<Undergoes> getListOfUndergoes() {
		return listOfUndergoes;
	}

	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
		this.listOfUndergoes = listOfUndergoes;
	}

	public String toString() {
		return "Stay [stayid=" + stayid + ", patient=" + patient + ", room=" + room + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", room2=" + room2 + ", patient2=" + patient2 + "]";
	}

}
