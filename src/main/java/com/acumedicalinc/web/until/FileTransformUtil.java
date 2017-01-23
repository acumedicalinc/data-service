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

import com.acumedicalinc.web.entity.Patient;

/**
 * 
 * upload file util functions
 *
 */
public class FileTransformUtil {
	
	public static List<Patient> fileToList(String[] strings){
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
}
