package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	File fs;

	public ExcelDataProvider(String filename, String name) {
		try {
			fs = new File("./src/test/resources/Testdata/" + filename + ".xlsx");
			FileInputStream fins = new FileInputStream(fs);
			workbook = new XSSFWorkbook(fins);
			sheet = workbook.getSheet(name);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void getSheetBasedOnSheetIndex(int index) {
		sheet = workbook.getSheetAt(index);
	}

	public int getRowCount() {
		return sheet.getLastRowNum();
	}

	public int getColumnCount(int row) {
		return sheet.getRow(row).getLastCellNum();
	}

	public String getStringValue(int row, int col) {
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

	public int getIntegerValue(int row, int col) {
		return (int) sheet.getRow(row).getCell(col).getNumericCellValue();
	}
	
	public void setCellData(int row,int col,String value)
	{
		sheet.getRow(row).createCell(col).setCellValue(value);
		try {
			FileOutputStream fout = new FileOutputStream(fs);
			workbook.write(fout);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExcelDataProvider excelDataProvider = new ExcelDataProvider("testdata", "Login");

		System.out.println(excelDataProvider.getRowCount()); // total number of rows-1
		System.out.println(excelDataProvider.getColumnCount(0));

		System.out.println(excelDataProvider.getStringValue(1, 0));
		System.out.println(excelDataProvider.getStringValue(1, 1));
	}
}
