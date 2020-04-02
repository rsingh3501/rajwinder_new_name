package com.qa.carreg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.NumberFormat.Style;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.poi.ss.usermodel.CellStyle;

import com.qa.carreg.base.TestBase;

import resources1.ExcelReader;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 5;
	public static ExcelReader excel = null;
	public static String TESTDATA_SHEET_PATH = "F:\\java tutorials\\Xampp.Carreg\\src\\main\\java\\com\\qa\\carreg\\testdata\\CarList.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public static Object[][] getTestData(String sheetName) {
		if (excel == null) {
			excel = new ExcelReader(TESTDATA_SHEET_PATH);
		}
		System.out.println(excel.getRowCount(sheetName));
		System.out.println(excel.getColumnCount(sheetName));
			Object data[][]= new Object[excel.getRowCount(sheetName)-1][excel.getColumnCount(sheetName)];
			for (int i = 2; i <= excel.getRowCount(sheetName); i++) {
				for (int k = 0; k < excel.getColumnCount(sheetName); k++) {
					data[i-2][k] = excel.getCellData(sheetName, k, i);
				
				}
			}
			return data;
			
			
			
			
		}
//	public static String[] getExpected(String sheetname) {
//		if (excel == null) {
//			excel = new ExcelReader(TESTDATA_SHEET_PATH);
//		}
//		
//		String expected[]= new String[excel.getRowCount(sheetname)-1];
//		
//		
//	}

	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}
}
