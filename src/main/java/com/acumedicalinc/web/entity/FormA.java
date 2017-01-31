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
@Table(name = "Raw Data Format A")
public class FormA {
	private static final long serialVersionUID = 1L;

	public FormA(){
	}
		
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name = "id", unique = true)
	private Long id;
	
	@Column
	private long time;
	
	@Column
	private long[] data;
	
	@Column
	private long timestamp;
	
	public Long getId() {
		return id;
	}
	
	public void setTime(long t){
		time = t;
	}
	
	public void setData(long[] d){
		data = d;
	}
	
	public void setTimestamp(long ts){
		timestamp = ts;
	}
	
}
