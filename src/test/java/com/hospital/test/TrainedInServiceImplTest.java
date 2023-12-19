package com.hospital.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.hospital.entities.Physician;
import com.hospital.entities.Procedure;
import com.hospital.entities.TrainedIn;
import com.hospital.repositories.TrainedInRepository;
import com.hospital.services.impl.TrainedInServiceImpl;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class TrainedInServiceImplTest {

    @Mock
    private TrainedInRepository trainedInRepository;

    @InjectMocks
    private TrainedInServiceImpl trainedInService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCertificate() {
        TrainedIn certificate = createDummyCertificate();

        when(trainedInRepository.save(any(TrainedIn.class))).thenReturn(certificate);

        boolean result = trainedInService.addCertificate(certificate);
        assertTrue(result);
        verify(trainedInRepository, times(1)).save(certificate);
    }

    @Test
    public void testGetProcedureByCertification() {
        List<TrainedIn> certificates = Arrays.asList(createDummyCertificate(), createDummyCertificate());

        when(trainedInRepository.findAll()).thenReturn(certificates);

        List<TrainedIn> allCertificates = trainedInService.getProcedureByCertification();
        assertEquals(certificates, allCertificates);
        verify(trainedInRepository, times(1)).findAll();
    }

    @Test
    public void testGetTreatment() {
        Integer physicianId = 1;
        List<Procedure> treatments = Arrays.asList(createDummyProcedure(), createDummyProcedure());

        when(trainedInRepository.findTreatmentByPhysician(physicianId)).thenReturn(treatments);

        List<Procedure> physicianTreatments = trainedInService.getTreatment(physicianId);
        assertEquals(treatments, physicianTreatments);
        verify(trainedInRepository, times(1)).findTreatmentByPhysician(physicianId);
    }

    @Test
    public void testGetPhysician() {
        Integer procedureId = 1;
        List<Physician> physicians = Arrays.asList(createDummyPhysician(), createDummyPhysician());

        when(trainedInRepository.findPhysicianByTreatment(procedureId)).thenReturn(physicians);

        List<Physician> procedurePhysicians = trainedInService.getPhysicican(procedureId);
        assertEquals(physicians, procedurePhysicians);
        verify(trainedInRepository, times(1)).findPhysicianByTreatment(procedureId);
    }

    @Test
    public void testUpdateCertificationExpires() {
        Integer physicianId = 1;
        Integer procedureId = 1;
        Date newCertificationExpires = new Date(procedureId);

        TrainedIn certificate = createDummyCertificate();

        when(trainedInRepository.findByPhysicianAndProcedure(physicianId, procedureId)).thenReturn(certificate);
        when(trainedInRepository.save(any(TrainedIn.class))).thenReturn(certificate);

        TrainedIn updatedCertificate = trainedInService.updateCertificationExpires(physicianId, procedureId, newCertificationExpires);
        assertEquals(newCertificationExpires, updatedCertificate.getCertificationexpires());
        verify(trainedInRepository, times(1)).findByPhysicianAndProcedure(physicianId, procedureId);
        verify(trainedInRepository, times(1)).save(any(TrainedIn.class));
    }

    // Helper method to create a dummy TrainedIn instance
    private TrainedIn createDummyCertificate() {
        return new TrainedIn(1, 1, new Date(0), new Date(0));
    }

    // Helper method to create a dummy Procedure instance
    private Procedure createDummyProcedure() {
        return new Procedure(1, "ProcedureA", 1000.0);
    }

    // Helper method to create a dummy Physician instance
    private Physician createDummyPhysician() {
        return new Physician(1, "John Doe", "Doctor", 123456789);
    }
}
