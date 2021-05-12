package com.multisysportal.testcases;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.reports.DailyReports;
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
		DailyReports reports = new DailyReports();
		reports.selectDate();
		reports.export();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
