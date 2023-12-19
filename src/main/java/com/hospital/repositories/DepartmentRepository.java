package com.hospital.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.entities.TrainedIn;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	@Query("select p from Physician p join p.listOfDepartment d where d.departmentid= :departmentid")
	Physician findHeadById(@Param("departmentid") Integer departmentid);

	@Query("select t from TrainedIn t JOIN t.physician2 p JOIN p.listOfDepartment d where d.departmentid= :departmentid")
	List<TrainedIn> findCertificationByHeadId(@Param("departmentid") Integer departmentid);

	List<Department> findByHead(Integer head);
	
	@Query("select d from Department d where d.head = :physicianId")
	 Department findDepartmentHeadByPhysicianId(@Param("physicianId") Integer physicianId);

}
