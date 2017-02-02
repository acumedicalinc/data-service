package com.acumedicalinc.web.until;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.acumedicalinc.web.entity.FormA;
import com.acumedicalinc.web.entity.Patient;

/**
 * 
 * upload file util functions
 *
 */
public class FileTransformUtil {
	
	//For reading in "patients", mostly for demo files.
	public static List<Patient> fileToPatientList(String[] strings){
		List<Patient> patients = new ArrayList<Patient>();
		
		for (String str : strings) {
			Patient p = new Patient();
			String[] line = str.split(",");
			p.setFirstName(line[0]);
			p.setLastName(line[1]);
			p.setTestValue(Float.parseFloat(line[2]));
			
			patients.add(p);
		}

		return patients;
	}
	
	//For reading in raw data that follows format A.
	public static List<FormA> fileToFormatAList(String[] strings, String timestamp){
		List<FormA> forms = new ArrayList<FormA>();
		
		//Reads in each row in the file and creates new table entry for each one.
		for(String str : strings){
			FormA f = new FormA();
			String[] line = str.split(",");
			
			//Add elements to FormA
			f.setTime(Long.parseLong(line[0]));
			long[] data = new long[8];
			for(int i = 0; i < 8; i++){
				data[i] = Long.parseLong(line[i+1]);
			}
			f.setData(data);
			f.setTimestamp(timestamp);
			
			//add entry to list of entries
			forms.add(f);
		}
		
		//returns list of entries for entire file
		return forms;
	}
}
