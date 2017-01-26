package com.acumedicalinc.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.acumedicalinc.web.entity.Patient;

@Transactional
public interface PatientDao  {
	public void insert(Patient patient);
	public void insert(List<Patient> patients);
	public List<Patient> findAll();
	public Patient findPatient(long patientId);
	void saveOrUpdate(Patient patient);
	void saveOrUpdate(List<Patient> patients);
}
