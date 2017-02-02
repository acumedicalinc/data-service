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
@Table(name = "RawDataFormatA")
public class FormA implements Serializable {
	private static final long serialVersionUID = 1L;

	public FormA(){
	}
		
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name = "id", unique = true)
	private Long id;
	
	@Column
	private Float time;
	
	@Column
	private Float data1;
	
	@Column
	private Float data2; 
	
	@Column
	private Float data3;
	
	@Column
	private Float data4;
	
	@Column
	private Float data5;
	
	@Column
	private Float data6;
	
	@Column
	private Float data7;
	
	@Column
	private Float data8;
	
	@Column
	private String timestamp;
	
	public Long getId() {
		return id;
	}
	
	public void setTime(float t){
		time = t;
	}
	
	public void setData(float[] d){
		d[0] = data1;
		d[1] = data2;
		d[2] = data3;
		d[3] = data4;
		d[4] = data5;
		d[5] = data6;
		d[6] = data7;
		d[7] = data8;
	}
	
	public void setTimestamp(String ts){
		timestamp = ts;
	}
	
}
