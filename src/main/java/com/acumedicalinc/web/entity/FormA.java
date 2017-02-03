package com.acumedicalinc.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author JC
 * 
 * table entry for entries of format A
 * 	format A:
 * 		9 columns; 
 * 			1st column = time, 
 * 			column 2-9 = channel data
 *
 */
@Entity
@Table(name = "raw_data_format1")
public class FormA implements Serializable {
	private static final long serialVersionUID = 1L;

	//Id in table, unique for each entry. Autogenerated.
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name = "id", unique = true)
	private Long id;
	
	//1st column in raw data file
	@Column
	private Date test_datetime;
	
	//2nd-9th columns in raw data file
	//Channels 1-8, may change names later
	@Column
	private Double channel1;
	@Column
	private Double channel2; 
	@Column
	private Double channel3;
	@Column
	private Double channel4;
	@Column
	private Double channel5;
	@Column
	private Double channel6;
	@Column
	private Double channel7;
	@Column
	private Double channel8;
	@Column
	private Double channel9;
	
	public Long getId() {
		return id;
	}

	public Date getTest_datetime() {
		return test_datetime;
	}
	public void setTest_datetime(Date test_datetime) {
		this.test_datetime = test_datetime;
	}
	public Double getChannel1() {
		return channel1;
	}
	public void setChannel1(Double channel1) {
		this.channel1 = channel1;
	}
	public Double getChannel2() {
		return channel2;
	}
	public void setChannel2(Double channel2) {
		this.channel2 = channel2;
	}
	public Double getChannel3() {
		return channel3;
	}
	public void setChannel3(Double channel3) {
		this.channel3 = channel3;
	}
	public Double getChannel4() {
		return channel4;
	}
	public void setChannel4(Double channel4) {
		this.channel4 = channel4;
	}
	public Double getChannel5() {
		return channel5;
	}
	public void setChannel5(Double channel5) {
		this.channel5 = channel5;
	}
	public Double getChannel6() {
		return channel6;
	}
	public void setChannel6(Double channel6) {
		this.channel6 = channel6;
	}
	public Double getChannel7() {
		return channel7;
	}
	public void setChannel7(Double channel7) {
		this.channel7 = channel7;
	}
	public Double getChannel8() {
		return channel8;
	}
	public void setChannel8(Double channel8) {
		this.channel8 = channel8;
	}
	public Double getChannel9() {
		return channel9;
	}
	public void setChannel9(Double channel9) {
		this.channel9 = channel9;
	}

	public FormA() {
	}
	
	public FormA(String[] values, Date timestamp) {
		this.test_datetime = timestamp;
		
		for (int i=0; i<9 && i<values.length; i++) {
			try {
				setFloat(i, values[i]);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void setFloat(int i, String floatStr) {
		switch (i) {
			case 0:
				channel1 = Double.parseDouble(floatStr);
				break;
			case 1:
				channel2 = Double.parseDouble(floatStr);
				break;
			case 2:
				channel3 = Double.parseDouble(floatStr);
				break;
			case 3:
				channel4 = Double.parseDouble(floatStr);
				break;
			case 4:
				channel5 = Double.parseDouble(floatStr);
				break;
			case 5:
				channel6 = Double.parseDouble(floatStr);
				break;
			case 6:
				channel7 = Double.parseDouble(floatStr);
				break;
			case 7:
				channel8 = Double.parseDouble(floatStr);
				break;
			case 8:
				channel9 = Double.parseDouble(floatStr);
				break;
			default:
				break;
		}
	}
}
