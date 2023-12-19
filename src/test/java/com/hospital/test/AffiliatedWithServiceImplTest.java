package com.hospital.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.hospital.entities.AffiliatedWith;
import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.repositories.AffiliatedWithRepository;
import com.hospital.services.impl.AffiliatedWithServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class AffiliatedWithServiceImplTest {

	@Mock
	private AffiliatedWithRepository affiliatedWithRepository;

	@InjectMocks
	private AffiliatedWithServiceImpl affiliatedWithService;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	private AffiliatedWith createDummyAffiliation() {
		return new AffiliatedWith(123, 1, true);
	}

	private Physician createDummyPhysician() {
		return new Physician(123, "Dr. Smith", "Cardiologist", 123456789);
	}

	private Department createDummyDepartment() {
		return new Department(1, "Cardiology", 123);
	}

	@Test
	public void testAddAffiliation() {
		AffiliatedWith affiliatedWith = createDummyAffiliation();

		when(affiliatedWithRepository.save(affiliatedWith)).thenReturn(affiliatedWith);

		assertTrue(affiliatedWithService.add(affiliatedWith));
		verify(affiliatedWithRepository, times(1)).save(affiliatedWith);
	}

	@Test
	public void testGetPhysicianByDepartment() {
		Integer departmentId = 1;
		List<Physician> physicians = Arrays.asList(createDummyPhysician());

		when(affiliatedWithRepository.findPhysicianByDepartment(departmentId)).thenReturn(physicians);

		List<Physician> retrievedPhysicians = affiliatedWithService.getPhysicianByDepartment(departmentId);
		assertEquals(physicians, retrievedPhysicians);
		verify(affiliatedWithRepository, times(1)).findPhysicianByDepartment(departmentId);
	}

	@Test
	public void testGetDepartmentByPhysician() {
		Integer physicianId = 123;
		List<Department> departments = Arrays.asList(createDummyDepartment());

		when(affiliatedWithRepository.findDepartmentByPhysician(physicianId)).thenReturn(departments);

		List<Department> retrievedDepartments = affiliatedWithService.getDepartmentByPhysician(physicianId);
		assertEquals(departments, retrievedDepartments);
		verify(affiliatedWithRepository, times(1)).findDepartmentByPhysician(physicianId);
	}

	@Test
	public void testGetByPhysicianId() {
		Integer departmentId = 1;

		when(affiliatedWithRepository.getPhysicianCount(departmentId)).thenReturn(1);

		Integer count = affiliatedWithService.getByPhysicianId(departmentId);
		assertEquals(1, count);
		verify(affiliatedWithRepository, times(1)).getPhysicianCount(departmentId);
	}

	@Test
	public void testGetPrimaryAffiliationByPhysician() {
		Integer physicianId = 123;

		when(affiliatedWithRepository.getPrimaryAffiliationByPhysician(physicianId)).thenReturn(true);

		boolean isPrimary = affiliatedWithService.getPrimaryAffiliationByPhysician(physicianId);
		assertTrue(isPrimary);
		verify(affiliatedWithRepository, times(1)).getPrimaryAffiliationByPhysician(physicianId);
	}

	@Test
	public void testUpdatePrimaryAffiliation() {
		Integer physicianId = 123;
		boolean newPrimaryAffiliation = true;

		when(affiliatedWithRepository.getPrimaryAffiliationByPhysician(physicianId)).thenReturn(false);

		boolean result = affiliatedWithService.updatePrimaryAffiliation(physicianId, newPrimaryAffiliation);
		assertTrue(result);
		verify(affiliatedWithRepository, times(1)).getPrimaryAffiliationByPhysician(physicianId);
	}

}
