package com.multisysportal.reports;

import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.ExcelApiTest;

public class MonthlyReports extends TestBase{

	public void selectDate() throws Throwable {
		Thread.sleep(3000);
		String sheetName = "Reports";
		ExcelApiTest eat = new ExcelApiTest(path);
		select("month_XPATH", eat.getCellData(sheetName, "Monthly", 2));
		select("myear_XPATH", eat.getCellData(sheetName, "Monthly", 3));
		Thread.sleep(3000);
	}
	
	
}
