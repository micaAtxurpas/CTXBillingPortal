package com.multisysportal.testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.ExcelApiTest;
import com.multisysportal.utilities.TestUtil;

public class Export_Daily_Reports extends TestBase{
	@Test
	public void export_Daily_Reports() throws Throwable {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("export_Daily_Reports", excel)) {
			throw new SkipException(
					"Skipping test " + "export_Daily_Reports".toUpperCase() + " with runmode exception F");
		}

		Thread.sleep(2000);
		log.debug("Export Reports Page successsfully accessed!");
		Reporter.log("Export Reports Page successsfully accessed!");

		TestActions exportReportsDaily = new TestActions();
		exportReportsDaily.clickReports();
		
		Thread.sleep(2000);
		TestActions daily = new TestActions();
		daily.clickReportsDaily();
		
		String sheetName = "Reports";
		
		Thread.sleep(2000);
		ExcelApiTest eat = new ExcelApiTest(path);
		type("date_XPATH", eat.getCellData(sheetName, "Daily", 2));
		
		Thread.sleep(2000);
		click("exportbtn_XPATH");

		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
