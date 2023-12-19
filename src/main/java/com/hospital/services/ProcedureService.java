package com.hospital.services;

import java.util.List;
import com.hospital.entities.Procedure;

public interface ProcedureService {

	boolean addTreatment(Procedure procedure);

	List<Procedure> getAll();

	Procedure getCostBy(Integer id);

	Procedure getCostByName(String name);

	Procedure updateCostBy(Integer id, Double cost);

	Procedure updateNameBy(Integer id, String name);


}
