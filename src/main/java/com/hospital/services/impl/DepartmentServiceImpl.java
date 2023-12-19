package com.hospital.services.impl;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.entities.TrainedIn;
import com.hospital.exceptions.handler.DepartmentNotFoundException;
import com.hospital.repositories.DepartmentRepository;
import com.hospital.repositories.PhysicianRepository;
import com.hospital.services.DepartmentService;
 
@Service
 
public class DepartmentServiceImpl implements DepartmentService {
 
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private PhysicianRepository physicianRepository;
 
	@Override
	public boolean addDepartment(Department department) {
		departmentRepository.save(department);
		return true;
	}
 
 
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
 
 
	public Department getById(Integer id) throws DepartmentNotFoundException{
		Optional<Department> department = departmentRepository.findById(id);
		if(department.isEmpty()) {
			throw new DepartmentNotFoundException("Department not found with id : "+id);
		}
		return department.get();
	}
 
 
	public Physician getHeadById(Integer id) {
		Optional<Department> department = departmentRepository.findById(id);
		if(department.isEmpty()) {
			throw new DepartmentNotFoundException("Department not found with id : "+id);
		}
		return departmentRepository.findHeadById(id);
 
	}
 
	public List<TrainedIn> getCertificationByDepartmentId(Integer departmentid) {
		Optional<Department> department = departmentRepository.findById(departmentid);
		if(department.isEmpty()) {
			throw new DepartmentNotFoundException("Department not found with id : "+departmentid);
		}
		
		if(departmentRepository.findCertificationByHeadId(departmentid).isEmpty()) {
			throw new DepartmentNotFoundException("Certification not found with id : "+departmentid);
		}else {
			return departmentRepository.findCertificationByHeadId(departmentid);
		}	
	}
 
	public List<Department> getDepartmentByHead(Integer head) {
		return departmentRepository.findByHead(head);
 
	}
 
	@Override
	public Department updateName(Integer deptid, String name) {
		Optional<Department> dept = departmentRepository.findById(deptid);
		if (dept != null) {
			dept.get().setName(name);
			departmentRepository.save(dept.get());
		}
		if(dept.isEmpty()) {
			throw new DepartmentNotFoundException("Department not found with id : "+deptid);
		}
		return dept.get();
	}
 
	@Override
	public Department updateHeadBy(Integer departmentid, Integer head) {
		Optional<Department> dept = departmentRepository.findById(departmentid);
		if (dept.isPresent()) {
			dept.get().setHead(head);
			departmentRepository.save(dept.get());
		}
		if(dept.isEmpty()) {
			throw new DepartmentNotFoundException("Department not found with id : "+departmentid);
		}
		return dept.get();
	}
	@Override
	public boolean isPhysicianHead(Integer physicianId) {
		Optional<Physician> physician = physicianRepository.findById(physicianId);
		if(physician.isEmpty()) {
			throw new DepartmentNotFoundException("Physician not found with id : "+physicianId);
		}
		 return departmentRepository.findDepartmentHeadByPhysicianId(physicianId) != null;
	}
 
}