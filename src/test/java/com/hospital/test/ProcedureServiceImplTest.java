package com.hospital.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.hospital.entities.Procedure;
import com.hospital.repositories.ProcedureRepository;
import com.hospital.services.impl.ProcedureServiceImpl;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class ProcedureServiceImplTest {

    @Mock
    private ProcedureRepository procedureRepository;

    @InjectMocks
    private ProcedureServiceImpl procedureService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddTreatment() {
        Procedure procedure = createDummyProcedure();

        when(procedureRepository.save(any(Procedure.class))).thenReturn(procedure);

        boolean result = procedureService.addTreatment(procedure);
        assertTrue(result);
        verify(procedureRepository, times(1)).save(procedure);
    }

    @Test
    public void testGetAll() {
        List<Procedure> procedures = Arrays.asList(createDummyProcedure(), createDummyProcedure());

        when(procedureRepository.findAll()).thenReturn(procedures);

        List<Procedure> allProcedures = procedureService.getAll();
        assertEquals(procedures, allProcedures);
        verify(procedureRepository, times(1)).findAll();
    }

    @Test
    public void testGetCostBy() {
        Integer procedureId = 1;
        Procedure procedure = createDummyProcedure();

        when(procedureRepository.findById(procedureId)).thenReturn(Optional.of(procedure));

        Procedure retrievedProcedure = procedureService.getCostBy(procedureId);
        assertEquals(procedure, retrievedProcedure);
        verify(procedureRepository, times(1)).findById(procedureId);
    }

    @Test
    public void testGetCostByName() {
        String procedureName = "ProcedureA";
        Procedure procedure = createDummyProcedure();

        when(procedureRepository.findCostByName(procedureName)).thenReturn(procedure);

        Procedure retrievedProcedure = procedureService.getCostByName(procedureName);
        assertEquals(procedure, retrievedProcedure);
        verify(procedureRepository, times(1)).findCostByName(procedureName);
    }

    @Test
    public void testUpdateCostBy() {
        Integer procedureId = 1;
        Procedure procedure = createDummyProcedure();

        when(procedureRepository.findById(procedureId)).thenReturn(Optional.of(procedure));
        when(procedureRepository.save(any(Procedure.class))).thenReturn(procedure);

        Double newCost = 1500.0;
        Procedure updatedProcedure = procedureService.updateCostBy(procedureId, newCost);
        assertEquals(newCost, updatedProcedure.getCost());
        verify(procedureRepository, times(1)).findById(procedureId);
        verify(procedureRepository, times(1)).save(any(Procedure.class));
    }

    @Test
    public void testUpdateNameBy() {
        Integer procedureId = 1;
        Procedure procedure = createDummyProcedure();

        when(procedureRepository.findById(procedureId)).thenReturn(Optional.of(procedure));
        when(procedureRepository.save(any(Procedure.class))).thenReturn(procedure);

        String newName = "NewProcedureName";
        Procedure updatedProcedure = procedureService.updateNameBy(procedureId, newName);
        assertEquals(newName, updatedProcedure.getName());
        verify(procedureRepository, times(1)).findById(procedureId);
        verify(procedureRepository, times(1)).save(any(Procedure.class));
    }

    // Helper method to create a dummy Procedure instance
    private Procedure createDummyProcedure() {
        return new Procedure(1, "ProcedureA", 1000.0);
    }
}
