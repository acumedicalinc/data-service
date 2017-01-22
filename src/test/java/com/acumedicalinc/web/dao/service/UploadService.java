package com.acumedicalinc.web.dao.service;

import java.util.List;

import com.acumedicalinc.web.entity.Patient;

public interface UploadService {
	public void insertPatient(List<Patient> patients);
}
