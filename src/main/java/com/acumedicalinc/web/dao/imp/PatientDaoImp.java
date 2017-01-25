package com.acumedicalinc.web.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
@Transactional
public class PatientDaoImp  implements  PatientDao {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(Patient patient) {
		entityManager.persist(patient);
		Session curr = sessionFactory.getCurrentSession();
		curr.saveOrUpdate(patient);
	}
	
	public void insert(List<Patient> patients) {

		Session curr = sessionFactory.getCurrentSession();
		
		for (Patient p: patients){
			entityManager.persist(p);
			curr.saveOrUpdate(p);
		}
		
		findAll();
	}

	public List<Patient> findAll() {

		Session curr = sessionFactory.getCurrentSession();
		return curr.createCriteria(Patient.class).list();
	}
	
	public Patient findPatient(long patientId) {

		Session curr = sessionFactory.getCurrentSession();
		Patient found = (Patient) curr.createCriteria(Patient.class)
						.add(Restrictions.eq("id", patientId))
						.list().get(0);
		return found;
	}
	
	@Bean (name="patientDao")
	public PatientDao patientDao() {
		return this;
	}
}
