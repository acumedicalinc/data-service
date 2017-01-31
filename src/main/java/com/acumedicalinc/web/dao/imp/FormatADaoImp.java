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

import com.acumedicalinc.web.entity.FormA;
import com.acumedicalinc.web.entity.Patient;
import com.acumedicalinc.web.dao.FormatADao;

@Repository
@Transactional
public class FormatADaoImp implements FormatADao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(FormA form){
		getSession().save(form);
	}
	@Override
	public void insert(List<FormA> forms){

		Session session = getSession();
		for (FormA f: forms){
			session.save(f);
		}
		session.flush();
		
		List<FormA> all = findAll();
		System.err.println("all counter: " + all.size());
	
	}
	@Override
	public List<FormA> findAll(){
		return getSession().createCriteria(FormA.class).list();
		
	}
	@Override
	public FormA findFormatA(long formAId){

		FormA found = (FormA) getSession().createCriteria(FormA.class)
						.add(Restrictions.eq("id", formAId))
						.list().get(0);
		return found;
		
	}
	@Override
	public void saveOrUpdate(FormA form){
		getSession().saveOrUpdate(form);
	}
	@Override
	public void saveOrUpdate(List<FormA> forms){
		for (FormA f: forms){
			saveOrUpdate(f);
		}
		
		findAll();
	}
	
	@Bean(name = "FormatADao")
	public FormatADao formatADao(){
		return this;
	}
	
	private Session getSession() {
		return sessionFactory.openSession();
	}
}