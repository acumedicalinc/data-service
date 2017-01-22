package com.acumedicalinc.web.dao.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.acumedicalinc.web.dao.PatientDao;
import com.acumedicalinc.web.dao.service.UploadService;
import com.acumedicalinc.web.entity.Patient;

public class UploadServiceImp implements UploadService {
	@Autowired
	PatientDao patientDao;

	@Override
	public void insertPatient(List<Patient> patients) {
		// TODO Auto-generated method stub
		for (Patient patient: patients){
			patientDao.insert(patient);
		}
	}

}
