package com.acumedicalinc.web.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.acumedicalinc.web.dao.service.UploadService;
import com.acumedicalinc.web.dao.until.FileTransformUtil;

@Controller
public class FileUploadController {
	
	private static final Logger logger = Logger
			.getLogger(FileUploadController.class);
	
	@Autowired
	UploadService uploadService;

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			insertPatients(name);
			
			return "/public/success.html";
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
	
	private void insertPatients(String filename) {
		uploadService.insertPatient(FileTransformUtil.fileToList(filename));
	}
}
