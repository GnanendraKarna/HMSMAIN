package com.hospital.services;

import java.sql.Date;
import java.util.List;

import com.hospital.entities.Physician;
import com.hospital.entities.Procedure;
import com.hospital.entities.TrainedIn;

public interface TrainedInService {

	boolean addCertificate(TrainedIn certificate);

	List<TrainedIn> getProcedureByCertification();

	List<Procedure> getTreatment(Integer physicianid);

	List<Physician> getPhysicican(Integer procedureid);

	TrainedIn updateCertificationExpires(Integer physicianid, Integer procedureid, Date certificationexpires);

}
