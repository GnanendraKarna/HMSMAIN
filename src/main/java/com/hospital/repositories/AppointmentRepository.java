package com.hospital.repositories;
 
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

 
import com.hospital.entities.Appointment;
import com.hospital.entities.Nurse;
import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.entities.Room;
 
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query("SELECT a FROM Appointment a WHERE a.startDateTime >= :startDate")
	List<Appointment> getAppointmentsByStartDate(Timestamp  startDate);
	//@Query("SELECT a.patient2 FROM Appointment a WHERE a.appointmentid = :appointmentId")
	@Query("SELECT p "
			+ "FROM Patient p "
			+ "JOIN Appointment a ON p.ssn = a.patient2.ssn "
			+ "WHERE a.appointmentid = :appointmentId")
	Patient getPatientDetailByAppointmentId(int appointmentId);

	@Query("SELECT p "
			+ "FROM Physician p "
			+ "JOIN Appointment a ON p.employeeid = a.physician2.employeeid "
			+ "WHERE a.appointmentid = :appointmentId")
	Physician getPhysicianDetailByAppointmentId(int appointmentId);
	@Query("SELECT n FROM Nurse n " +
	           "JOIN Appointment a ON n.employeeid = a.nurse.employeeid " +
	           "WHERE a.appointmentid = :appointmentId")
	Nurse getNurseDetailByAppointmentId(int appointmentId);
	@Query("SELECT a.examinationroom FROM Appointment a WHERE a.appointmentid = :appointmentId")
	String findExaminationRoomByAppointmentId( int appointmentId);

	@Query("SELECT DISTINCT p FROM Physician p " +
	           "JOIN Appointment a ON p.employeeid = a.physician2.employeeid " +
	           "WHERE a.patient2.ssn = :patientId")
	List<Physician> findPhysiciansByPatientId(int patientId);
	@Query("SELECT DISTINCT p FROM Physician p " +
	           "JOIN Appointment a ON p.employeeid = a.physician2.employeeid " +
	           "WHERE a.patient2.ssn = :patientId "+
	           "AND a.startDateTime = :date")
	Physician getPhysicianDetailByPatientIdOnDate(Timestamp  date,int patientId);
	@Query("SELECT n "
			+ "FROM Nurse n "
			+ "JOIN Appointment a ON n.employeeid = a.nurse.employeeid "
			+ "WHERE a.patient = :patientId")
	List<Nurse> getAllNurseByPatientId(int patientId);
//	@Query("SELECT DISTINCT p "
//			+ "FROM Physician p "
//			+ "JOIN Appointment a ON p.employeeid = a.physician2.employeeid "
//			+ "JOIN Nurse n ON a.nurse.employeeid = n.employeeid "
//			+ "WHERE n.employeeid = :nurseId "
//			+ "AND a.startDateTime <= :date "
//			+ "AND a.endDateTime >= :date")
//	Physician getPhysicianDetailByNurseIdOnDate(Timestamp date,int nurseId);
	@Query("SELECT a.nurse FROM Appointment a " +
		       "WHERE a.patient = :patientId AND a.startDateTime = :date")
	Nurse getNurseBypatientIdOnDate(Timestamp date,int patientId);
	@Query("SELECT DISTINCT a.startDateTime "
			+ "FROM Appointment a "
			+ "WHERE a.patient2.ssn = :patientId")
	List<Timestamp> listOfAppointmentDatesByPatientId(int patientId);
	@Query("SELECT DISTINCT p "
			+ "FROM Patient p "
			+ "JOIN Appointment a ON p.ssn = a.patient2.ssn "
			+ "WHERE a.physician2.employeeid = :physicianId")
	List<Patient> listOfPatientsByPhysicianId(int physicianId);
	@Query("SELECT DISTINCT p "
			+ "FROM Patient p "
			+ "JOIN Appointment a ON p.ssn = a.patient2.ssn "
			+ "WHERE a.physician2.employeeid = :physicianId "
			+ "AND a.startDateTime = :date")
	List<Patient> listOfPatientsByPhysicianIdOnDate(int physicianId, Timestamp date);
	@Query("SELECT p "
			+ "FROM Patient p "
			+ "JOIN Appointment a ON p.ssn = a.patient2.ssn "
			+ "WHERE a.physician2.employeeid = :physicianId "
			+ "  AND p.ssn = :patientId")
	Patient getPatientByPatientIdAndPhysicianId(int physicianId, int patientId);
	@Query("SELECT DISTINCT p "
			+ "FROM Patient p "
			+ "JOIN Appointment a ON p.ssn = a.patient2.ssn "
			+ "WHERE a.nurse.employeeid = :nurseId")
	List<Patient> getListOfPatientsCheckedByNurse(int nurseId);//completed
	@Query("SELECT p FROM Patient p " +
		       "JOIN Appointment a ON p.ssn = a.patient " +
		       "WHERE p.ssn = :patientId AND a.prepnurse = :nurseId")
	Patient getPatientBynurseIdAndPatientId(int nurseId, int patientId);
	@Query("SELECT DISTINCT p FROM Patient p " +
		       "JOIN Appointment a ON p.ssn = a.patient " +
		       "WHERE a.prepnurse = :nurseId AND FUNCTION('DATE', a.startDateTime) = :date")
	List<Patient> getPatientBynurseIdOnDate(int nurseId, Timestamp date);
	@Query("SELECT r FROM Room r " +
		       "JOIN Stay s ON r.roomnumber = s.room " +
		       "JOIN Appointment a ON s.patient = a.patient " +
		       "WHERE a.patient = :patientId AND :date BETWEEN a.startDateTime AND a.endDateTime")
	Room getRoomDetailsBypatientIdOnDate(int patientId, Timestamp date);
	@Query("SELECT DISTINCT r FROM Room r " +
		       "JOIN Stay s ON r.roomnumber = s.room " +
		       "JOIN Appointment a ON s.patient = a.patient " +
		       "JOIN Physician p ON a.physician = p.employeeid " +
		       "WHERE p.employeeid = :physicianId AND :date BETWEEN a.startDateTime AND a.endDateTime")
	List<Room> getRoomListByPhysicianIdOnDate(int physicianId, Timestamp date);
	@Query("SELECT DISTINCT r FROM Room r " +
		       "JOIN Stay s ON r.roomnumber = s.room " +
		       "JOIN Appointment a ON s.patient = a.patient " +
		       "JOIN Nurse n ON a.prepnurse = n.employeeid " +
		       "WHERE n.employeeid = :nurseId AND :date BETWEEN a.startDateTime AND a.endDateTime")
	List<Room> getRoomListByNurseIdOnDate(int nurseId, Timestamp date);
	@Modifying
	@Query("UPDATE Appointment a SET a.examinationroom = :newExaminationRoom "
			+ "WHERE a.appointmentid = :appointmentId")
	Integer updateExaminationRoomByAppointmentId(String newExaminationRoom,int appointmentId);
 
}