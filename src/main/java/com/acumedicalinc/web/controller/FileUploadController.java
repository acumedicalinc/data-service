package com.acumedicalinc.web.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.acumedicalinc.web.service.UploadService;
import com.acumedicalinc.web.until.FileTransformUtil;

@Controller
@Component
public class FileUploadController {


	@Autowired
	UploadService uploadService;



	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {


		try {

			if (!file.isEmpty()) {
				ByteArrayInputStream stream = new   ByteArrayInputStream(file.getBytes());
				String myString = IOUtils.toString(stream, "UTF-8");
				
				//TODO Check filename to decide which table to put data in
				if(name.contains("patient_A")){
					String[] n = name.split("_");
					String timeStamp = "";
					
					//Searches for string that looks like a timestamp.
					//Only works for dates formatted with the year first, between 2010 and 2019.
					for(int i = 0; i < n.length; i++){
						if(n[i].startsWith("201")){
							timeStamp = (n[i]);
						}
					}
					
					insertFormatA(myString.split("\n"), timeStamp);
				}
				//For reading in demo file
				else if(name.contains("demo")){
					insertPatients(myString.split("\n"));
				}
				
				return "/public/success.html";
			} else {
				return "You failed to upload " + name
						+ " because the file was empty.";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/public/error.html";
	}

	public void insertPatients(String[] strings) {
		uploadService.insertPatients(FileTransformUtil.fileToPatientList(strings));
	}
	public void insertFormatA(String[] strings, String timestamp){
		uploadService.insertFormatA(FileTransformUtil.fileToFormatAList(strings, timestamp));
	}
}
