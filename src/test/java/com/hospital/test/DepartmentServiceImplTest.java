package com.hospital.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.entities.TrainedIn;
import com.hospital.exceptions.handler.DepartmentNotFoundException;
import com.hospital.repositories.DepartmentRepository;
import com.hospital.repositories.PhysicianRepository;
import com.hospital.services.impl.DepartmentServiceImpl;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private PhysicianRepository physicianRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddDepartment() {
        Department department = createDummyDepartment();

        when(departmentRepository.save(department)).thenReturn(department);

        assertTrue(departmentService.addDepartment(department));
        verify(departmentRepository, times(1)).save(department);
    }

    @Test
    public void testGetAllDepartments() {
        List<Department> departments = Arrays.asList(createDummyDepartment());

        when(departmentRepository.findAll()).thenReturn(departments);

        List<Department> retrievedDepartments = departmentService.getAllDepartments();
        assertEquals(departments, retrievedDepartments);
        verify(departmentRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Integer id = 1;
        Department department = createDummyDepartment();

        when(departmentRepository.findById(id)).thenReturn(Optional.of(department));

        Department retrievedDepartment = departmentService.getById(id);
        assertEquals(department, retrievedDepartment);
        verify(departmentRepository, times(1)).findById(id);
    }

    @Test
    public void testGetByIdDepartmentNotFoundException() {
        Integer id = 1;

        when(departmentRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> departmentService.getById(id));
        verify(departmentRepository, times(1)).findById(id);
    }

    @Test
    public void testGetHeadById() {
        Integer id = 1;
        Department department = createDummyDepartment();
        Physician headPhysician = createDummyPhysician();

        when(departmentRepository.findById(id)).thenReturn(Optional.of(department));
        when(departmentRepository.findHeadById(id)).thenReturn(headPhysician);

        Physician retrievedHeadPhysician = departmentService.getHeadById(id);
        assertEquals(headPhysician, retrievedHeadPhysician);
        verify(departmentRepository, times(1)).findById(id);
        verify(departmentRepository, times(1)).findHeadById(id);
    }

    @Test
    public void testGetHeadByIdDepartmentNotFoundException() {
        Integer id = 1;

        when(departmentRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> departmentService.getHeadById(id));
        verify(departmentRepository, times(1)).findById(id);
    }

    @Test
    public void testGetCertificationByDepartmentId() {
        Integer departmentId = 1;
        Department department = createDummyDepartment();
        List<TrainedIn> certifications = Arrays.asList(createDummyTrainedIn());

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));
        when(departmentRepository.findCertificationByHeadId(departmentId)).thenReturn(certifications);

        List<TrainedIn> retrievedCertifications = departmentService.getCertificationByDepartmentId(departmentId);
        assertEquals(certifications, retrievedCertifications);
        verify(departmentRepository, times(1)).findById(departmentId);
    }

    @Test
    public void testGetCertificationByDepartmentIdDepartmentNotFoundException() {
        Integer departmentId = 1;

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> departmentService.getCertificationByDepartmentId(departmentId));
        verify(departmentRepository, times(1)).findById(departmentId);
    }

    @Test
    public void testGetDepartmentByHead() {
        Integer head = 1;
        List<Department> departments = Arrays.asList(createDummyDepartment());

        when(departmentRepository.findByHead(head)).thenReturn(departments);

        List<Department> retrievedDepartments = departmentService.getDepartmentByHead(head);
        assertEquals(departments, retrievedDepartments);
        verify(departmentRepository, times(1)).findByHead(head);
    }

    @Test
    public void testUpdateName() {
        Integer deptId = 1;
        String newName = "New Department";
        Department department = createDummyDepartment();

        when(departmentRepository.findById(deptId)).thenReturn(Optional.of(department));
        when(departmentRepository.save(department)).thenReturn(department);

        Department updatedDepartment = departmentService.updateName(deptId, newName);

        assertEquals(newName, updatedDepartment.getName());
        verify(departmentRepository, times(1)).findById(deptId);
        verify(departmentRepository, times(1)).save(department);
    }

    
    @Test
    public void testUpdateHeadBy() {
        Integer departmentId = 1;
        Integer newHead = 2;
        Department department = createDummyDepartment();

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));
        when(departmentRepository.save(department)).thenReturn(department);

        Department updatedDepartment = departmentService.updateHeadBy(departmentId, newHead);

        assertEquals(newHead, updatedDepartment.getHead());
        verify(departmentRepository, times(1)).findById(departmentId);
        verify(departmentRepository, times(1)).save(department);
    }

    @Test
    public void testUpdateHeadByDepartmentNotFoundException() {
        Integer departmentId = 1;
        Integer newHead = 2;

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> departmentService.updateHeadBy(departmentId, newHead));
        verify(departmentRepository, times(1)).findById(departmentId);
    }

    

    @Test
    public void testIsPhysicianHeadPhysicianNotFoundException() {
        Integer physicianId = 1;

        when(physicianRepository.findById(physicianId)).thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> departmentService.isPhysicianHead(physicianId));
        verify(physicianRepository, times(1)).findById(physicianId);
    }

    @Test
    public void testIsPhysicianHeadNotHeadPhysician() {
        Integer physicianId = 1;
        Physician physician = createDummyPhysician();

        when(physicianRepository.findById(physicianId)).thenReturn(Optional.of(physician));
        when(departmentRepository.findDepartmentHeadByPhysicianId(physicianId)).thenReturn(null);

        boolean result = departmentService.isPhysicianHead(physicianId);

        assertFalse(result);
        verify(physicianRepository, times(1)).findById(physicianId);
        verify(departmentRepository, times(1)).findDepartmentHeadByPhysicianId(physicianId);
    }

    // Helper method to create a dummy Department instance
    private Department createDummyDepartment() {
        return new Department(1, "Cardiology", 1);
    }

    // Helper method to create a dummy Physician instance
    private Physician createDummyPhysician() {
        return new Physician(1, "Dr. Smith", "Cardiologist", 123456789);
    }

    // Helper method to create a dummy TrainedIn instance
    private TrainedIn createDummyTrainedIn() {
        return new TrainedIn();
    }
}
