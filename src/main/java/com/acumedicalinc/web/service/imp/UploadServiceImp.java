package com.acumedicalinc.web.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.acumedicalinc.web.dao.FormatADao;
import com.acumedicalinc.web.dao.PatientDao;
import com.acumedicalinc.web.entity.FormA;
import com.acumedicalinc.web.entity.Patient;
import com.acumedicalinc.web.service.UploadService;
/**
 * 
 * Implemented Upload Service
 *
 */
@Configuration
@ComponentScan
public class UploadServiceImp implements UploadService {
	@Autowired
	PatientDao patientDao;
	
	@Autowired
	FormatADao formADao;
	
	@Override
	public void insertPatients(List<Patient> patients) {
			patientDao.insert(patients);
	}
	
	@Override
	public List<Patient> getPatients( ) {
			return patientDao.findAll();
	}
	
	@Override
	public void insertPatient(Patient patient) {
			patientDao.insert(patient);
	}

	@Bean (name="uploadService")
	public UploadService uploadService() {
		return this;
	}

	@Override
	public void insertFormatA(List<FormA> forms) {
		formADao.insert(forms);
	}
	@Override
	public void insertFormatA(FormA form) {
		formADao.insert(form);
	}

	@Override
	public List<FormA> getFormatA() {
		formADao.findAll();
		return null;
	}
}
