package com.hospital.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hospital.entities.Physician;
import com.hospital.repositories.PhysicianRepository;
import com.hospital.services.impl.PhysicianServiceImpl;

public class PhysicianServiceImplTest {

    @Mock
    private PhysicianRepository physicianRepository;

    @InjectMocks
    private PhysicianServiceImpl physicianService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterPhysician() {
        Physician physician = createDummyPhysician();

        when(physicianRepository.save(physician)).thenReturn(physician);

        assertTrue(physicianService.registerPhysician(physician));
        verify(physicianRepository, times(1)).save(physician);
    }

    @Test
    public void testGetByName() {
        String physicianName = "Dr. Smith";
        Physician physician = createDummyPhysician();

        when(physicianRepository.findByName(physicianName)).thenReturn(physician);

        assertEquals(physician, physicianService.getByName(physicianName));
        verify(physicianRepository, times(1)).findByName(physicianName);
    }

    @Test
    public void testGetByPosition() {
        String position = "Cardiologist";
        Physician physician1 = createDummyPhysician();
        Physician physician2 = createDummyPhysician();

        when(physicianRepository.findByPosition(position)).thenReturn(Arrays.asList(physician1, physician2));

        List<Physician> physicians = physicianService.getByPosition(position);
        assertEquals(2, physicians.size());
        verify(physicianRepository, times(1)).findByPosition(position);
    }

    @Test
    public void testGetByEmpId() {
        Integer empId = 123;
        Physician physician = createDummyPhysician();

        when(physicianRepository.findById(empId)).thenReturn(Optional.of(physician));

        assertEquals(physician, physicianService.getByEmpId(empId));
        verify(physicianRepository, times(1)).findById(empId);
    }

    @Test
    public void testUpdatePosition() {
        Integer empId = 123;
        String newPosition = "Neurologist";
        Physician physician = createDummyPhysician();

        when(physicianRepository.findById(empId)).thenReturn(Optional.of(physician));
        when(physicianRepository.save(physician)).thenReturn(physician);

        Physician updatedPhysician = physicianService.updatePosition(empId, newPosition);

        assertEquals(newPosition, updatedPhysician.getPosition());
        verify(physicianRepository, times(1)).findById(empId);
        verify(physicianRepository, times(1)).save(physician);
    }

    @Test
    public void testUpdateName() {
        Integer empId = 123;
        String newName = "Dr. Johnson";
        Physician physician = createDummyPhysician();

        when(physicianRepository.findById(empId)).thenReturn(Optional.of(physician));
        when(physicianRepository.save(physician)).thenReturn(physician);

        Physician updatedPhysician = physicianService.updateName(empId, newName);

        assertEquals(newName, updatedPhysician.getName());
        verify(physicianRepository, times(1)).findById(empId);
        verify(physicianRepository, times(1)).save(physician);
    }

    @Test
    public void testUpdateSSN() {
        Integer empId = 123;
        Integer newSSN = 987654321;
        Physician physician = createDummyPhysician();

        when(physicianRepository.findById(empId)).thenReturn(Optional.of(physician));
        when(physicianRepository.save(physician)).thenReturn(physician);

        Physician updatedPhysician = physicianService.updateSSN(empId, newSSN);

        assertEquals(newSSN, updatedPhysician.getSsn());
        verify(physicianRepository, times(1)).findById(empId);
        verify(physicianRepository, times(1)).save(physician);
    }

    // Helper method to create a dummy physician
    private Physician createDummyPhysician() {
        return new Physician(123, "Dr. Smith", "Cardiologist", 123456789);
    }
}
