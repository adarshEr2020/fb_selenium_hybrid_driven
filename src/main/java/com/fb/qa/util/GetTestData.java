package com.fb.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetTestData {
	public static String TEST_SHEET_PATH = "E:\\ADARSH Current data\\facebook\\src\\main\\java\\com\\fb\\qa\\testdata\\login_data.xlsx";

	public static Workbook book;
	public static Sheet sheet;

	public Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_SHEET_PATH);
			book = WorkbookFactory.create(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			} 
		}
		return data;
	}

}
