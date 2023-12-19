package com.hospital.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospital.entities.Physician;
import com.hospital.entities.Procedure;
import com.hospital.entities.TrainedIn;
import com.hospital.entities.id.TrainedInId;

public interface TrainedInRepository extends JpaRepository<TrainedIn, TrainedInId> {

	@Query("select p from Procedure p JOIN p.listofTrainedIn t where t.physician= :physicianid")
	List<Procedure> findTreatmentByPhysician(@Param("physicianid") Integer physicianid);

	@Query("select p from Physician p JOIN p.listOfTrainedIn t where t.treatment= :procedureid")
	List<Physician> findPhysicianByTreatment(@Param("procedureid") Integer procedureid);

	// @Query("select p from Procedure p JOIN p.trainedIn t where
	// t.certificationexpires BETWEEN :CURRENT_DATE AND :oneMonthFromNow")
	// List<Procedure> findByExpirationDate(@Param("Current Date")Date start,
	// @Param("oneMonthFromNow")Date end);

	@Query("SELECT t FROM TrainedIn t WHERE t.physician = :physicianid AND t.treatment= :procedureid")
	TrainedIn findByPhysicianAndProcedure(@Param("physicianid") Integer physicianid,
			@Param("procedureid") Integer procedureid);

}
