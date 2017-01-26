package com.acumedicalinc.web.dao.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.acumedicalinc.web.dao.PatientDao;
import com.acumedicalinc.web.entity.Patient;

/**
 * ToDo: implement this class with Hibernate or String Repository
 *
 */
@Repository
@Transactional
public class PatientDaoImp  implements  PatientDao {
	
//	@PersistenceContext
//	 private EntityManager entityManager;
//	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(Patient patient) {
		getSession().save(patient);
	}
	
	@Override
	public void insert(List<Patient> patients) {
		Session session = getSession();
		for (Patient p: patients){
			session.save(p);
		}
		session.flush();
		
		List<Patient> all = findAll();
		System.err.println("all counter: " + all.size());
	}
	
	@Override
	public void saveOrUpdate(Patient patient) {
		getSession().saveOrUpdate(patient);
	}
	
	@Override
	public void saveOrUpdate(List<Patient> patients) {
		for (Patient p: patients){
			saveOrUpdate(p);
		}
		
		findAll();
	}

	@Override
	public List<Patient> findAll() {
		return getSession().createCriteria(Patient.class).list();
	}
	
	@Override
	public Patient findPatient(long patientId) {

		Patient found = (Patient) getSession().createCriteria(Patient.class)
						.add(Restrictions.eq("id", patientId))
						.list().get(0);
		return found;
	}
	
	@Bean (name="patientDao")
	public PatientDao patientDao() {
		return this;
	}
	

	private Session getSession() {
		return sessionFactory.openSession();
	}
		
}
