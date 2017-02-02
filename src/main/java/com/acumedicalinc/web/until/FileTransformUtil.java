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

	public static List<FormA> fileToFormatAList(String[] strings, String timestamp){
		List<FormA> forms = new ArrayList<FormA>();

		for(String str : strings){
			FormA f = new FormA();
			String[] line = str.split(",");
			float time;

			//Add elements to FormA
			//TODO: currently cannot parse string "0" for some reason???
			//      Just throws NumberFormatException
			String test = line[0];
			if(test.equals("0")){
				time = (float)0;
			}
			else{
				time = Float.parseFloat(line[0]);
			}
			float[] data = new float[8];
			for(int i = 0; i < 8; i++){
				data[i] = Float.parseFloat(line[i+1]);
			}
			f.setTime(time);
			f.setData(data);
			f.setTimestamp(timestamp);

			forms.add(f);
		}

		return forms;
	}
}
