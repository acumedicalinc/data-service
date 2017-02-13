package com.acumedicalinc.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.acumedicalinc.web.entity.FormA;
/**
 * 
 * @author JC
 * Data Access Object for FormA object
 */
@Transactional
public interface FormatADao  {
	public void insert(FormA form);
	public void insert(List<FormA> forms);
	public List<FormA> findAll();
	public FormA findFormatA(long formAId);
	void saveOrUpdate(FormA form);
	void saveOrUpdate(List<FormA> forms);
}