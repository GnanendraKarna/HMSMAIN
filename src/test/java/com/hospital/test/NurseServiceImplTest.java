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

import com.hospital.entities.Nurse;
import com.hospital.repositories.NurseRepository;
import com.hospital.services.impl.NurseServiceImpl;

public class NurseServiceImplTest {

    @Mock
    private NurseRepository nurseRepository;

    @InjectMocks
    private NurseServiceImpl nurseService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterNurse() {
        Nurse nurse = createDummyNurse();

        when(nurseRepository.save(any(Nurse.class))).thenReturn(nurse);

        Nurse registeredNurse = nurseService.registerNurse(nurse);
        assertEquals(nurse, registeredNurse);
        verify(nurseRepository, times(1)).save(nurse);
    }

    @Test
    public void testGetAll() {
        List<Nurse> nurses = Arrays.asList(createDummyNurse(), createDummyNurse());

        when(nurseRepository.findAll()).thenReturn(nurses);

        List<Nurse> allNurses = nurseService.getAll();
        assertEquals(nurses, allNurses);
        verify(nurseRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Integer nurseId = 1;
        Nurse nurse = createDummyNurse();

        when(nurseRepository.findById(nurseId)).thenReturn(Optional.of(nurse));

        Nurse retrievedNurse = nurseService.getById(nurseId);
        assertEquals(nurse, retrievedNurse);
        verify(nurseRepository, times(1)).findById(nurseId);
    }

    @Test
    public void testGetPositionBy() {
        Integer nurseId = 1;
        Nurse nurse = createDummyNurse();

        when(nurseRepository.findById(nurseId)).thenReturn(Optional.of(nurse));

        String position = nurseService.getPositionBy(nurseId);
        assertEquals(nurse.getPosition(), position);
        verify(nurseRepository, times(1)).findById(nurseId);
    }

    @Test
    public void testGetRegisteredBy() {
        Integer nurseId = 1;
        Nurse nurse = createDummyNurse();

        when(nurseRepository.findById(nurseId)).thenReturn(Optional.of(nurse));

        boolean registered = nurseService.getRegisteredBy(nurseId);
        assertEquals(nurse.getRegistered(), registered);
        verify(nurseRepository, times(1)).findById(nurseId);
    }

    @Test
    public void testUpdateRegisteredBy() {
        Integer nurseId = 1;
        Nurse nurse = createDummyNurse();

        when(nurseRepository.findById(nurseId)).thenReturn(Optional.of(nurse));
        when(nurseRepository.save(any(Nurse.class))).thenReturn(nurse);

        Boolean newRegisteredStatus = !nurse.getRegistered();
        Nurse updatedNurse = nurseService.updateRegisteredBy(nurseId, newRegisteredStatus);
        assertEquals(newRegisteredStatus, updatedNurse.getRegistered());
        verify(nurseRepository, times(1)).findById(nurseId);
        verify(nurseRepository, times(1)).save(any(Nurse.class));
    }

    @Test
    public void testUpdateSsnBy() {
        Integer nurseId = 1;
        Nurse nurse = createDummyNurse();

        when(nurseRepository.findById(nurseId)).thenReturn(Optional.of(nurse));
        when(nurseRepository.save(any(Nurse.class))).thenReturn(nurse);

        Integer newSsn = 123456789;
        Nurse updatedNurse = nurseService.updateSsnBy(nurseId, newSsn);
        assertEquals(newSsn, updatedNurse.getSsn());
        verify(nurseRepository, times(1)).findById(nurseId);
        verify(nurseRepository, times(1)).save(any(Nurse.class));
    }

    // Helper method to create a dummy Nurse instance
    private Nurse createDummyNurse() {
        return new Nurse(1, "John Doe", "Registered Nurse", true, 123456789);
    }
}
