package com.multisysportal.reports;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.ExcelApiTest;

public class DailyReports extends TestBase {

	public void selectDate() throws Exception {
		
		String sheetName = "Reports";
		
		Thread.sleep(2000);
		ExcelApiTest eat = new ExcelApiTest(path);
		type("date_XPATH", eat.getCellData(sheetName, "Daily", 2));
		Thread.sleep(2000);
	}

	public void export() throws Throwable {
		
		Thread.sleep(2000);
		click("exportbtn_XPATH");

		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
