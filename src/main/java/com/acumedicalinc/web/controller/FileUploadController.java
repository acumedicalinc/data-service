package com.acumedicalinc.web.controller;


import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		Date fileTimestamp = new Date();
		
		try {
			if (file != null && (name == null || name.trim().length()==0)) {
				name = file.getOriginalFilename();
			}
			
			Pattern r = Pattern.compile("\\d{8}_\\d{1,2}_\\d{1,2}_\\d{1,2}");
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_hh_mm_ss");
			Matcher m = r.matcher(name);

			if (m.find()) {
				try {
					fileTimestamp = format.parse(m.group());
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			if (!file.isEmpty()) {
				ByteArrayInputStream stream = new   ByteArrayInputStream(file.getBytes());
				
				if (name.endsWith(".xlsx")){
					loadXlsxExcelData(stream, 9, fileTimestamp);
				}
				else if (name.endsWith(".xls")){
					loadXlsExcelData(stream, 9, fileTimestamp);
				}
				
				//TODO Check filename to decide which table to put data in
				else if(name.endsWith(".csv") && name.contains("patient_A")){
					String myString = IOUtils.toString(stream, "UTF-8");
					insertFormatA(myString.split("\n"), fileTimestamp);
				}
				
				//For reading in demo file
				else if(name.contains("demo")){
					String myString = IOUtils.toString(stream, "UTF-8");
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
	public void insertFormatA(String[] strings, Date timestamp){
		uploadService.insertFormatA(FileTransformUtil.fileToFormatAList(strings, timestamp));
	}
	
	public void loadXlsxExcelData(InputStream excelFile, int length, Date timestamp) throws IOException {
		uploadService.insertFormatA(FileTransformUtil.xlsxExcel(excelFile, length, timestamp));
	}
	
	public void loadXlsExcelData(InputStream excelFile, int length, Date timestamp) throws IOException {
		uploadService.insertFormatA(FileTransformUtil.xlsExcel(excelFile, length, timestamp));
	}
}
