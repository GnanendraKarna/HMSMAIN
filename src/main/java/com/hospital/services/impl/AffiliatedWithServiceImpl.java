package com.hospital.services.impl;
 
import java.util.List;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.hospital.entities.AffiliatedWith;
import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.exceptions.handler.AffiliatedWithNotFoundException;
import com.hospital.repositories.AffiliatedWithRepository;
import com.hospital.services.AffiliatedWithService;
 
@Service
public class AffiliatedWithServiceImpl implements AffiliatedWithService {
 
    @Autowired
    private AffiliatedWithRepository affiliatedWithRepository;
 
    public boolean add(AffiliatedWith affiliatedWith) throws AffiliatedWithNotFoundException {
        try {
            affiliatedWithRepository.save(affiliatedWith);
            return true;
        } catch (Exception e) {
            throw new AffiliatedWithNotFoundException("Error while adding affiliation: " + e.getMessage());
        }
    }
 
    @Override
    public List<Physician> getPhysicianByDepartment(Integer departmentId) throws AffiliatedWithNotFoundException {
            List<Physician> physicians = affiliatedWithRepository.findPhysicianByDepartment(departmentId);
            if (physicians.isEmpty()) {
            	throw new AffiliatedWithNotFoundException("Department Not Found with Id: " +departmentId);
        } else {
        	 return physicians;
        }
    }
 
    @Override
    public List<Department> getDepartmentByPhysician(Integer physicianId) throws AffiliatedWithNotFoundException {
            List<Department> departments = affiliatedWithRepository.findDepartmentByPhysician(physicianId);
            if (departments.isEmpty()) {
            	 throw new AffiliatedWithNotFoundException("Physician Not Found with Id:"+physicianId);
           
        } else {
        	 return departments;
        }
    }
 
    @Override
    public Integer getByPhysicianId(Integer departmentId) throws AffiliatedWithNotFoundException {
            Integer physicianCount = affiliatedWithRepository.getPhysicianCount(departmentId);
            if (physicianCount == null || physicianCount == 0) {
                throw new AffiliatedWithNotFoundException("Department Not Found with Id: " + departmentId);
            } else {
                return physicianCount;
            }
    }
 
 
    public boolean getPrimaryAffiliationByPhysician(Integer physicianId) throws AffiliatedWithNotFoundException {
        try {
            return affiliatedWithRepository.getPrimaryAffiliationByPhysician(physicianId);
        } catch (Exception e) {
            throw new AffiliatedWithNotFoundException("Physician Not Found with Id:"+physicianId);
        }
    }
 
    public Boolean updatePrimaryAffiliation(Integer physicianid, boolean primaryAffiliation) throws AffiliatedWithNotFoundException {
        try {
            boolean affiliatedWith = affiliatedWithRepository.getPrimaryAffiliationByPhysician(physicianid);
            if (affiliatedWith != primaryAffiliation) {
                affiliatedWith = primaryAffiliation;
            }
            return primaryAffiliation;
        } catch (Exception e) {
            throw new AffiliatedWithNotFoundException("Error while updating primary affiliation: " + e.getMessage());
        }
    }
}