package com.ExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {

	static String value;
	

	public static HashMap<String, HashMap<String, String>> retriveData() throws Exception {
		HashMap<String, HashMap<String, String>> hm1 = new HashMap<String, HashMap<String, String>>();

		File f = new File(System.getProperty("user.dir") + "\\TestData.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet1");
		Row headerRow = sheet.getRow(0);
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row currentRow = sheet.getRow(i);
			HashMap<String, String> currentHash = new HashMap<String, String>();
			for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
				Cell cell = currentRow.getCell(0);
				int cellType = cell.getCellType();
				if (cellType == 1) {

					value = cell.getStringCellValue();
				}

				else if (cellType == 0) {

					if (DateUtil.isCellDateFormatted(cell)) {

						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat sim = new SimpleDateFormat("dd-mmm-yy");
						value = sim.format(dateCellValue);
					}

					else {

						double numericCellValue = cell.getNumericCellValue();
						long l = (long) numericCellValue;
						value = String.valueOf(l);

					}
				}

				Cell cell2 = currentRow.getCell(j);
				int cellType2 = cell2.getCellType();

				if (cellType2 == 1) {

					currentHash.put(headerRow.getCell(j).getStringCellValue(), cell2.getStringCellValue());
				}

				else if (cellType2 == 0) {

					if (DateUtil.isCellDateFormatted(cell2)) {

						Date dateCellValue2 = cell2.getDateCellValue();
						SimpleDateFormat sim = new SimpleDateFormat("dd-mmm-yy");
						// value = sim.format(dateCellValue2);
						currentHash.put(headerRow.getCell(j).getStringCellValue(), sim.format(dateCellValue2));
					}

					else {

						double numericCellValue2 = cell2.getNumericCellValue();
						long l2 = (long) numericCellValue2;
						// value = String.valueOf(l2);
						currentHash.put(headerRow.getCell(j).getStringCellValue(), String.valueOf(l2));

					}
				}

			}

			hm1.put(value, currentHash);

		}
		return hm1;
	}

}
