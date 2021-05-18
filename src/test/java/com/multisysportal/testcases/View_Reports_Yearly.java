package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;

public class View_Reports_Yearly extends TestBase {

	public static String viewReports;

	@Test
	public void view_Reports_Yearly() throws Throwable {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("view_Reports_Yearly", excel)) {
			throw new SkipException(
					"Skipping test " + "view_Reports_Yearly".toUpperCase() + " with runmode exception F");
		}

		Thread.sleep(2000);
		log.debug("Reports Page successsfully accessed!");
		Reporter.log("Reports Page successsfully accessed!");

		TestActions action = new TestActions();
		action.clickReports();
		viewReports = "T";

		Thread.sleep(2000);
		TestActions yearly = new TestActions();
		yearly.clickReportsYearly();

		// Disregard com.multisysportal.reports
//		Thread.sleep(2000);
//		YearlyReports reports = action.clickReportsYearly();
//		reports.selectDate(); 
	}
}
