package com.multisysportal.reports;

import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.ExcelApiTest;

public class CustomReports extends TestBase{

	public void selectDate() throws Throwable {
		
		String sheetName = "Reports";
		Thread.sleep(3000);
		
		ExcelApiTest eat = new ExcelApiTest(path);
		
		type("dateFrom_XPATH",eat.getCellData(sheetName, "Custom", 2));
		type("dateTo_XPATH",eat.getCellData(sheetName, "Custom", 3));
		
		Thread.sleep(3000);
	}
	
}
