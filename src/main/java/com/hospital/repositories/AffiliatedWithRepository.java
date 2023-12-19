package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.hospital.entities.AffiliatedWith;
import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.entities.id.AffiliatedWithId;

import java.util.List;

public interface AffiliatedWithRepository extends JpaRepository<AffiliatedWith, AffiliatedWithId> {

	@Query("select p from Physician p join p.listOfAffiliatedWith a where a.department= :departmentid")
	List<Physician> findPhysicianByDepartment(@Param("departmentid") Integer departmentid);

	@Query("select d from Department d join d.listOfAffiliatedWith a where a.physician= :physicianid")
	List<Department> findDepartmentByPhysician(@Param("physicianid") Integer physicianid);

	@Query("select count(physician) from AffiliatedWith a where a.department= :deptid ")
	Integer getPhysicianCount(@Param("deptid") Integer deptid);

	@Query("select a.primaryaffiliation from AffiliatedWith a where a.physician= :physicianid")
	boolean getPrimaryAffiliationByPhysician(@Param("physicianid") Integer physicianid);

}
