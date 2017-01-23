package com.acumedicalinc.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.acumedicalinc.web.entity.Patient;

 
@RepositoryRestResource
@Repository(value = "PatientRepository")
public interface PatientRepository extends CrudRepository<Patient, Long> {

}
