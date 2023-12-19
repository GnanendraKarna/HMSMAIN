package com.hospital.services;

import java.util.List;

import com.hospital.entities.AffiliatedWith;
import com.hospital.entities.Department;
import com.hospital.entities.Physician;

public interface AffiliatedWithService {

	boolean add(AffiliatedWith afw);

	List<Physician> getPhysicianByDepartment(Integer departmentid);

	List<Department> getDepartmentByPhysician(Integer physicianid);

	Integer getByPhysicianId(Integer deptId);

	boolean getPrimaryAffiliationByPhysician(Integer physicianId);

	Boolean updatePrimaryAffiliation(Integer physicianid, boolean pa);

}
