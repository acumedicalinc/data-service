package com.acumedicalinc.web.dao.until;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.acumedicalinc.web.entity.Patient;

/**
 * 
 * upload file util functions
 *
 */
public class FileTransformUtil {
	private static final Logger logger = Logger.getLogger(FileTransformUtil.class);

	public static List<Patient> fileToList(String filename){
		List<Patient> patients = new ArrayList<Patient>();
		
		// ToDo: get patient Objects list with file name
		try {
			byte[] bytes = filename.getBytes();

			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + filename);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			logger.info("Server File Location="
					+ serverFile.getAbsolutePath());

			//return "You successfully uploaded file=" + filename;
		} catch (Exception e) {
			//return "You failed to upload " + filename + " => " + e.getMessage();
		}
		
		return patients;
	}
}
