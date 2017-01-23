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
		
			insertPatients(myString.split("\n"));
			
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
		uploadService.insertPatients(FileTransformUtil.fileToList(strings));
	}
}
