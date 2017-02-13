package com.acumedicalinc.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Patient")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	public Patient() {
	}
	
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name = "id", unique = true)
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName; 
	
	@Column
	private float testValue;

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public float getTestValue() {
		return testValue;
	}
	public void setTestValue(float testValue) {
		this.testValue = testValue;
	}

}
