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

import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.repositories.PatientRepository;
import com.hospital.repositories.PhysicianRepository;
import com.hospital.services.impl.PatientServiceImpl;

public class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PhysicianRepository physicianRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @SuppressWarnings("deprecation")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPatient() {
        Patient patient = createDummyPatient();
        when(patientRepository.save(patient)).thenReturn(patient);

        assertTrue(patientService.addPatient(patient));
        verify(patientRepository, times(1)).save(patient);
    }

    @Test
    public void testGetAll() {
        Patient patient1 = createDummyPatient();
        Patient patient2 = createDummyPatient();
        List<Patient> patients = Arrays.asList(patient1, patient2);

        when(patientRepository.findAll()).thenReturn(patients);

        assertEquals(patients, patientService.getAll());
        verify(patientRepository, times(1)).findAll();
    }

    @Test
    public void testGetByPcp() {
        Integer pcp = 123;
        Patient patient = createDummyPatient();
        List<Patient> patients = Arrays.asList(patient);

        when(patientRepository.findByPcp(pcp)).thenReturn(patients);

        assertEquals(patients, patientService.getByPcp(pcp));
        verify(patientRepository, times(1)).findByPcp(pcp);
    }

    @Test
    public void testGetDetailsByPcp() {
        Integer pcp = 123;
        Integer ssn = 123456789;
        Physician physician = createDummyPhysician();
        Patient patient = createDummyPatient();

        // Set up the mocks
        when(physicianRepository.findById(pcp)).thenReturn(Optional.of(physician));
        when(patientRepository.findById(ssn)).thenReturn(Optional.of(patient));
        when(patientRepository.getPatientDetailsBy(pcp, ssn)).thenReturn(patient);
        Patient result = patientService.getDetailsByPcp(pcp, ssn);
        verify(physicianRepository, times(1)).findById(pcp);
        verify(patientRepository, times(1)).findById(ssn);
        verify(patientRepository, times(1)).getPatientDetailsBy(pcp, ssn);
        assertNotNull(result);
        assertEquals(patient, result);
    }

    @Test
    public void testGetInsuranceIdBy() {
        Integer ssn = 456;
        Patient patient = createDummyPatient();
        when(patientRepository.findById(ssn)).thenReturn(Optional.of(patient));

        assertEquals(patient.getInsuranceid(), patientService.getInsuranceIdBy(ssn));
        verify(patientRepository, times(1)).findById(ssn);
    }

    @Test
    public void testUpdateAddressBy() {
        Integer ssn = 456;
        String newAddress = "New Address";
        Patient patient = createDummyPatient();
        when(patientRepository.findById(ssn)).thenReturn(Optional.of(patient));

        assertEquals(patient, patientService.updateAddressBy(ssn, newAddress));
        assertEquals(newAddress, patient.getAddress());
        verify(patientRepository, times(1)).save(patient);
    }

    @Test
    public void testUpdatePhoneBy() {
        Integer ssn = 789;
        String newPhone = "123-456-7890";
        Patient patient = createDummyPatient();
        when(patientRepository.findById(ssn)).thenReturn(Optional.of(patient));

        assertEquals(patient, patientService.updatePhoneBy(ssn, newPhone));
        assertEquals(newPhone, patient.getPhone());
        verify(patientRepository, times(1)).save(patient);
    }

    // Helper method to create a dummy patient
    private Patient createDummyPatient() {
        Patient patient = new Patient();
        patient.setSsn(123456789);
        patient.setName("John Doe");
        patient.setAddress("123 Main St");
        patient.setPhone("555-1234");
        patient.setInsuranceid(987654321);
        patient.setPcp(123); // Assuming a valid physician ID
        return patient;
    }

    // Helper method to create a dummy physician
    private Physician createDummyPhysician() {
        Physician physician = new Physician();
        physician.setEmployeeid(123);
        // Add more fields as needed
        return physician;
    }
}
