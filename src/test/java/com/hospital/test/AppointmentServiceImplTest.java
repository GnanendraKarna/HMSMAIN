package com.hospital.test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.hospital.entities.Appointment;
import com.hospital.entities.Nurse;
import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.entities.Room;
import com.hospital.repositories.AppointmentRepository;
import com.hospital.services.impl.AppointmentServiceImpl;
 
public class AppointmentServiceImplTest {
 
    @Mock
    private AppointmentRepository appointmentRepository;
 
    @InjectMocks
    private AppointmentServiceImpl appointmentService;
 
    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testAddAppointment() {
        Appointment appointment = createDummyAppointment();
 
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
 
        Appointment addedAppointment = appointmentService.addAppointment(appointment);
        assertNotNull(addedAppointment);
        assertEquals(appointment, addedAppointment);
        verify(appointmentRepository, times(1)).save(appointment);
    }
 
    @Test
    public void testGetAllAppointments() {
        List<Appointment> appointments = Arrays.asList(createDummyAppointment());
 
        when(appointmentRepository.findAll()).thenReturn(appointments);
 
        List<Appointment> retrievedAppointments = appointmentService.getAllAppointments();
        assertEquals(appointments, retrievedAppointments);
        verify(appointmentRepository, times(1)).findAll();
    }
 
    @Test
    public void testGetAppointmentsByStartDate() {
        Timestamp startDate = Timestamp.valueOf("2023-01-01 10:00:00");
        List<Appointment> appointments = Arrays.asList(createDummyAppointment());
 
        when(appointmentRepository.getAppointmentsByStartDate(startDate)).thenReturn(appointments);
 
        List<Appointment> retrievedAppointments = appointmentService.getAppointmentsByStartDate(startDate);
        assertEquals(appointments, retrievedAppointments);
        verify(appointmentRepository, times(1)).getAppointmentsByStartDate(startDate);
    }
 
    @Test
    public void testGetPatientByAppointmentId() {
        int appointmentId = 123456789;
        Patient patient = createDummyPatient();
 
        when(appointmentRepository.getPatientDetailByAppointmentId(appointmentId)).thenReturn(patient);
 
        Patient retrievedPatient = appointmentService.getPatientByAppointmentId(appointmentId);
        assertNotNull(retrievedPatient);
        assertEquals(patient, retrievedPatient);
        verify(appointmentRepository, times(1)).getPatientDetailByAppointmentId(appointmentId);
    }
 
    @Test
    public void testGetPhysicianByAppointmentId() {
        int appointmentId = 123456789;
        Physician physician = createDummyPhysician();
 
        when(appointmentRepository.getPhysicianDetailByAppointmentId(appointmentId)).thenReturn(physician);
 
        Physician retrievedPhysician = appointmentService.getPhysicianByAppointmentId(appointmentId);
        assertNotNull(retrievedPhysician);
        assertEquals(physician, retrievedPhysician);
        verify(appointmentRepository, times(1)).getPhysicianDetailByAppointmentId(appointmentId);
    }
 
    @Test
    public void testGetNurseByAppointmentId() {
        int appointmentId = 123456789;
        Nurse nurse = createDummyNurse();
 
        when(appointmentRepository.getNurseDetailByAppointmentId(appointmentId)).thenReturn(nurse);
 
        Nurse retrievedNurse = appointmentService.getNurseByAppointmentId(appointmentId);
        assertNotNull(retrievedNurse);
        assertEquals(nurse, retrievedNurse);
        verify(appointmentRepository, times(1)).getNurseDetailByAppointmentId(appointmentId);
    }
 
    @Test
    public void testGetExaminationroomByAppointmentId() {
        int appointmentId = 123456789;
        String examinationRoom = "Room123";
 
        when(appointmentRepository.findExaminationRoomByAppointmentId(appointmentId)).thenReturn(examinationRoom);
 
        String retrievedExaminationRoom = appointmentService.getExaminationroomByAppointmentId(appointmentId);
        assertNotNull(retrievedExaminationRoom);
        assertEquals(examinationRoom, retrievedExaminationRoom);
        verify(appointmentRepository, times(1)).findExaminationRoomByAppointmentId(appointmentId);
    }
 
    @Test
    public void testGetPhysiciansByPatientId() {
        int patientId = 987654321;
        List<Physician> physicians = Arrays.asList(createDummyPhysician());
 
        when(appointmentRepository.findPhysiciansByPatientId(patientId)).thenReturn(physicians);
 
        List<Physician> retrievedPhysicians = appointmentService.getPhysiciansByPatientId(patientId);
        assertEquals(physicians, retrievedPhysicians);
        verify(appointmentRepository, times(1)).findPhysiciansByPatientId(patientId);
    }
 
    @Test
    public void testGetPhysicianDetailByPatientIdOnDate() {
        Timestamp date = Timestamp.valueOf("2023-01-01 10:00:00");
        int patientId = 987654321;
        Physician physician = createDummyPhysician();
 
        when(appointmentRepository.getPhysicianDetailByPatientIdOnDate(date, patientId)).thenReturn(physician);
 
        Physician retrievedPhysician = appointmentService.getPhysicianDetailByPatientIdOnDate(date, patientId);
        assertNotNull(retrievedPhysician);
        assertEquals(physician, retrievedPhysician);
        verify(appointmentRepository, times(1)).getPhysicianDetailByPatientIdOnDate(date, patientId);
    }
 
    @Test
    public void testGetAllNurseByPatientId() {
        int patientId = 987654321;
        List<Nurse> nurses = Arrays.asList(createDummyNurse());
 
        when(appointmentRepository.getAllNurseByPatientId(patientId)).thenReturn(nurses);
 
        List<Nurse> retrievedNurses = appointmentService.getAllNurseByPatientId(patientId);
        assertEquals(nurses, retrievedNurses);
        verify(appointmentRepository, times(1)).getAllNurseByPatientId(patientId);
    }
 
    @Test
    public void testGetNurseBypatientIdOnDate() {
        Timestamp date = Timestamp.valueOf("2023-01-01 10:00:00");
        int patientId = 987654321;
        Nurse nurse = createDummyNurse();
 
        when(appointmentRepository.getNurseBypatientIdOnDate(date, patientId)).thenReturn(nurse);
 
        Nurse retrievedNurse = appointmentService.getNurseBypatientIdOnDate(date, patientId);
        assertNotNull(retrievedNurse);
        assertEquals(nurse, retrievedNurse);
        verify(appointmentRepository, times(1)).getNurseBypatientIdOnDate(date, patientId);
    }
 
    @Test
    public void testListOfAppointmentDatesByPatientId() {
        int patientId = 987654321;
        List<Timestamp> appointmentDates = Arrays.asList(Timestamp.valueOf("2023-01-01 10:00:00"));
 
        when(appointmentRepository.listOfAppointmentDatesByPatientId(patientId)).thenReturn(appointmentDates);
 
        List<Timestamp> retrievedAppointmentDates = appointmentService.listOfAppointmentDatesByPatientId(patientId);
        assertEquals(appointmentDates, retrievedAppointmentDates);
        verify(appointmentRepository, times(1)).listOfAppointmentDatesByPatientId(patientId);
    }
 
    @Test
    public void testListOfPatientsByPhysicianId() {
        int physicianId = 123456789;
        List<Patient> patients = Arrays.asList(createDummyPatient());
 
        when(appointmentRepository.listOfPatientsByPhysicianId(physicianId)).thenReturn(patients);
 
        List<Patient> retrievedPatients = appointmentService.listOfPatientsByPhysicianId(physicianId);
        assertEquals(patients, retrievedPatients);
        verify(appointmentRepository, times(1)).listOfPatientsByPhysicianId(physicianId);
    }
 
    @Test
    public void testListOfPatientsByPhysicianIdOnDate() {
        int physicianId = 123456789;
        Timestamp date = Timestamp.valueOf("2023-01-01 10:00:00");
        List<Patient> patients = Arrays.asList(createDummyPatient());
 
        when(appointmentRepository.listOfPatientsByPhysicianIdOnDate(physicianId, date)).thenReturn(patients);
 
        List<Patient> retrievedPatients = appointmentService.listOfPatientsByPhysicianIdOnDate(physicianId, date);
        assertEquals(patients, retrievedPatients);
        verify(appointmentRepository, times(1)).listOfPatientsByPhysicianIdOnDate(physicianId, date);
    }
 
    @Test
    public void testGetPatientByPatientIdAndPhysicianId() {
        int physicianId = 123456789;
        int patientId = 987654321;
        Patient patient = createDummyPatient();
 
        when(appointmentRepository.getPatientByPatientIdAndPhysicianId(physicianId, patientId)).thenReturn(patient);
 
        Patient retrievedPatient = appointmentService.getPatientByPatientIdAndPhysicianId(physicianId, patientId);
        assertNotNull(retrievedPatient);
        assertEquals(patient, retrievedPatient);
        verify(appointmentRepository, times(1)).getPatientByPatientIdAndPhysicianId(physicianId, patientId);
    }
 
    @Test
    public void testGetListOfPatientsCheckedByNurse() {
        int nurseId = 555555555;
        List<Patient> patients = Arrays.asList(createDummyPatient());
 
        when(appointmentRepository.getListOfPatientsCheckedByNurse(nurseId)).thenReturn(patients);
 
        List<Patient> retrievedPatients = appointmentService.getListOfPatientsCheckedByNurse(nurseId);
        assertEquals(patients, retrievedPatients);
        verify(appointmentRepository, times(1)).getListOfPatientsCheckedByNurse(nurseId);
    }
 
    @Test
    public void testGetPatientBynurseIdAndPatientId() {
        int nurseId = 555555555;
        int patientId = 987654321;
        Patient patient = createDummyPatient();
 
        when(appointmentRepository.getPatientBynurseIdAndPatientId(nurseId, patientId)).thenReturn(patient);
 
        Patient retrievedPatient = appointmentService.getPatientBynurseIdAndPatientId(nurseId, patientId);
        assertNotNull(retrievedPatient);
        assertEquals(patient, retrievedPatient);
        verify(appointmentRepository, times(1)).getPatientBynurseIdAndPatientId(nurseId, patientId);
    }
 
    @Test
    public void testGetPatientBynurseIdOnDate() {
        int nurseId = 555555555;
        Timestamp date = Timestamp.valueOf("2023-01-01 10:00:00");
        List<Patient> patients = Arrays.asList(createDummyPatient());
 
        when(appointmentRepository.getPatientBynurseIdOnDate(nurseId, date)).thenReturn(patients);
 
        List<Patient> retrievedPatients = appointmentService.getPatientBynurseIdOnDate(nurseId, date);
        assertEquals(patients, retrievedPatients);
        verify(appointmentRepository, times(1)).getPatientBynurseIdOnDate(nurseId, date);
    }
 
    @Test
    public void testGetRoomDetailsBypatientIdOnDate() {
        int patientId = 987654321;
        Timestamp date = Timestamp.valueOf("2023-01-01 10:00:00");
        Room room = createDummyRoom();
 
        when(appointmentRepository.getRoomDetailsBypatientIdOnDate(patientId, date)).thenReturn(room);
 
        Room retrievedRoom = appointmentService.getRoomDetailsBypatientIdOnDate(patientId, date);
        assertNotNull(retrievedRoom);
        assertEquals(room, retrievedRoom);
        verify(appointmentRepository, times(1)).getRoomDetailsBypatientIdOnDate(patientId, date);
    }
 
    @Test
    public void testGetRoomListByPhysicianIdOnDate() {
        int physicianId = 123456789;
        Timestamp date = Timestamp.valueOf("2023-01-01 10:00:00");
        List<Room> rooms = Arrays.asList(createDummyRoom());
 
        when(appointmentRepository.getRoomListByPhysicianIdOnDate(physicianId, date)).thenReturn(rooms);
 
        List<Room> retrievedRooms = appointmentService.getRoomListByPhysicianIdOnDate(physicianId, date);
        assertEquals(rooms, retrievedRooms);
        verify(appointmentRepository, times(1)).getRoomListByPhysicianIdOnDate(physicianId, date);
    }
 
    @Test
    public void testGetRoomListByNurseIdOnDate() {
        int nurseId = 555555555;
        Timestamp date = Timestamp.valueOf("2023-01-01 10:00:00");
        List<Room> rooms = Arrays.asList(createDummyRoom());
 
        when(appointmentRepository.getRoomListByNurseIdOnDate(nurseId, date)).thenReturn(rooms);
 
        List<Room> retrievedRooms = appointmentService.getRoomListByNurseIdOnDate(nurseId, date);
        assertEquals(rooms, retrievedRooms);
        verify(appointmentRepository, times(1)).getRoomListByNurseIdOnDate(nurseId, date);
    }
 
    @Test
    public void testUpdateExaminationRoomByAppointmentId() {
        String newExaminationRoom = "NewRoom123";
        int appointmentId = 123456789;
 
        when(appointmentRepository.updateExaminationRoomByAppointmentId(newExaminationRoom, appointmentId)).thenReturn(1);
 
        assertTrue(appointmentService.updateExaminationRoomByAppointmentId(newExaminationRoom, appointmentId));
        verify(appointmentRepository, times(1)).updateExaminationRoomByAppointmentId(newExaminationRoom, appointmentId);
    }
private Appointment createDummyAppointment() {
    Appointment appointment = new Appointment();
    // Set appointment properties as needed for testing
    appointment.getAppointmentid();
    appointment.setStartDateTime(Timestamp.valueOf("2023-01-01 10:00:00"));
    // Set other properties...
 
    return appointment;
}
 
private Patient createDummyPatient() {
    Patient patient = new Patient();
    // Set patient properties as needed for testing
    patient.setSsn(987654321);
    patient.setName("John Doe");
    // Set other properties...
 
    return patient;
}
 
private Physician createDummyPhysician() {
    Physician physician = new Physician();
    // Set physician properties as needed for testing
    physician.setEmployeeid(123456789);
    physician.setName("Dr. Smith");
    // Set other properties...
 
    return physician;
}
 
private Nurse createDummyNurse() {
    Nurse nurse = new Nurse();
    // Set nurse properties as needed for testing
    nurse.setEmployeeid(555555555);
    nurse.setName("Nurse Johnson");
    // Set other properties...
 
    return nurse;
}
 
private Room createDummyRoom() {
    Room room = new Room();
    // Set room properties as needed for testing
    room.setRoomnumber(1);
    // Set other properties...
 
    return room;
}
}