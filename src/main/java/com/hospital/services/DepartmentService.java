package com.hospital.services;

import java.util.List;

import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.entities.TrainedIn;

public interface DepartmentService {

	boolean addDepartment(Department department);

	List<Department> getAllDepartments();

	Department getById(Integer id);

	Physician getHeadById(Integer id);

	List<TrainedIn> getCertificationByDepartmentId(Integer departmentid);

	List<Department> getDepartmentByHead(Integer head);

	Department updateHeadBy(Integer departmentid, Integer head);

	Department updateName(Integer deptid, String name);
	boolean isPhysicianHead(Integer physicianId);

}
