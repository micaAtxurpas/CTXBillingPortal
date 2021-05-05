package com.multisysportal.base;

import java.io.File;

import com.multisysportal.utilities.ExcelApiTest;

public class Main{

	
	public static void main(String[] args) throws Exception {
		String sheetName = "Reports";
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator 
				+ "excel" + File.separator + "testdata.xlsx";
		
		ExcelApiTest eat = new ExcelApiTest(path);
		System.out.println(sheetName);
		System.out.println(eat.getCellData(sheetName, "Monthly", 2));
		System.out.println(eat.getCellData(sheetName, "Monthly", 3));
		System.out.println(eat.getCellData(sheetName, "Daily", 2));
	}

}
