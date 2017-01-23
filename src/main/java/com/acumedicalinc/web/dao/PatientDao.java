package com.acumedicalinc.web.dao;

import java.util.List;

import com.acumedicalinc.web.entity.Patient;

public interface PatientDao {
	public void insert(Patient patient);
	public void insert(List<Patient> patients);
	public List<Patient> findAll();
	public Patient findPatient(long patientId);
}
