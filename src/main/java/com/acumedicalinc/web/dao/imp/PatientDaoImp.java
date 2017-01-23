package com.acumedicalinc.web.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.acumedicalinc.web.repository.PatientRepository;
import com.acumedicalinc.web.dao.PatientDao;
import com.acumedicalinc.web.entity.Patient;

/**
 * ToDo: implement this class with Hibernate or String Repository
 *
 */
@Repository
public class PatientDaoImp  implements  PatientDao {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
//	@Autowired
//	PatientRepository repo;
	
	@Override
	public void insert(Patient patient) {
		entityManager.persist(patient);
	}
	
	public void insert(List<Patient> patients) {
//		repo.save(patients);
		
		for (Patient p: patients)
			entityManager.persist(p);
		
		findAll();
	}

	public List<Patient> findAll() {
//		return repo.findAll();
		
		return null;
	}
	
	public Patient findPatient(long patientId) {
//		return (Patient) repo.findOne(patientId);
		return null;
	}
	
	@Bean (name="patientDao")
	public PatientDao patientDao() {
		return this;
	}
}
