package com.acumedicalinc.web.service;

import java.util.List;

import com.acumedicalinc.web.entity.FormA;
import com.acumedicalinc.web.entity.Patient;

public interface UploadService {
	public void insertPatients(List<Patient> patients);
	public void insertPatient(Patient patient);
	public List<Patient> getPatients();
	public void insertFormatA(List<FormA> forms);
	public void insertFormatA(FormA form);
	public List<FormA> getFormatA();
}
