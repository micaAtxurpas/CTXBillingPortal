package com.multisysportal.reports;

import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.ExcelApiTest;

public class YearlyReports extends TestBase{
	
	public void selectDate() throws Throwable {
		Thread.sleep(3000);
		String sheetName = "Reports";
		Thread.sleep(2000);
		ExcelApiTest eat = new ExcelApiTest(path);
		select("yyear_XPATH", eat.getCellData(sheetName, "Yearly", 2));
		Thread.sleep(3000);
	}
	
	
}
