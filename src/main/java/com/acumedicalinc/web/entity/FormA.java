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
	private Long time;
	
	@Column
	private Long data1;
	
	@Column
	private Long data2; 
	
	@Column
	private Long data3;
	
	@Column
	private Long data4;
	
	@Column
	private Long data5;
	
	@Column
	private Long data6;
	
	@Column
	private Long data7;
	
	@Column
	private Long data8;
	
	@Column
	private Long timestamp;
	
	public Long getId() {
		return id;
	}
	
	public void setTime(long t){
		time = t;
	}
	
	public void setData(long[] d){
		d[0] = data1;
		d[1] = data2;
		d[2] = data3;
		d[3] = data4;
		d[4] = data5;
		d[5] = data6;
		d[6] = data7;
		d[7] = data8;
	}
	
	public void setTimestamp(long ts){
		timestamp = ts;
	}
	
}
