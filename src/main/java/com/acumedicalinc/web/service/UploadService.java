package com.acumedicalinc.web.service;

import java.util.List;

import com.acumedicalinc.web.entity.Patient;

public interface UploadService {
	public void insertPatients(List<Patient> patients);
	public void insertPatient(Patient patient);
	public List<Patient> getPatients();
}
