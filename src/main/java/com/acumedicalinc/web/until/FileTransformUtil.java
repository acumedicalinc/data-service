package com.acumedicalinc.web.until;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.acumedicalinc.web.entity.FormA;
import com.acumedicalinc.web.entity.Patient;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * 
 * upload file util functions
 *
 */
public class FileTransformUtil {

	// For reading in "patients", mostly for demo files.
	public static List<Patient> fileToPatientList(String[] strings) {
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

	// For reading in raw data that follows format A.
	public static List<FormA> fileToFormatAList(String[] strings, Date timestamp) {
		List<FormA> forms = new ArrayList<FormA>();

		// Reads in each row in the file and creates new table entry for each
		// one.
		for (String str : strings) {

			String[] line = str.split(",");

			// Add elements to FormA
			FormA f = new FormA(line, timestamp);

			// add entry to list of entries
			forms.add(f);
		}

		// returns list of entries for entire file
		return forms;
	}

	public static List<FormA> readExcel(String filename) throws IOException {
		FileInputStream excelFile = new FileInputStream(new File(filename));
		Date date = new Date();

		List<FormA> list = (filename.endsWith("xlsx") ? xlsxExcel(excelFile, 9, date) : xlsExcel(excelFile, 9, date));

		excelFile.close();

		return list;

	}

	public static List<FormA> xlsxExcel(InputStream excelFile, int length, Date timestamp) throws IOException {
		return readExcel(new XSSFWorkbook(excelFile), length, timestamp);
	}

	public static List<FormA> xlsExcel(InputStream excelFile, int length, Date timestamp) throws IOException {
		return readExcel(new HSSFWorkbook(excelFile), length, timestamp);
	}

	public static List<FormA> readExcel(Workbook workbook, int length, Date timestamp) {
		List<FormA> forms = new ArrayList<FormA>();

		Sheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();

		while (iterator.hasNext()) {

			Row currentRow = iterator.next();
			if (currentRow == null) {
				continue;
			}

			Iterator<Cell> cellIterator = currentRow.iterator();
			String[] values = new String[length];
			int index = 0;

			while (cellIterator.hasNext()) {

				Cell currentCell = cellIterator.next();

				if (currentCell == null || index >= length) {
					continue;
				}
				// getCellTypeEnum shown as deprecated for version 3.15
				// getCellTypeEnum ill be renamed to getCellType starting from
				// version 4.0
				if (currentCell.getCellTypeEnum() == CellType.STRING) {
					values[index] = currentCell.getStringCellValue();
				} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
					values[index] = "" + currentCell.getNumericCellValue();
				}

				index++;
			}

			forms.add(new FormA(values, timestamp));

		}

		return forms;
	}
}
