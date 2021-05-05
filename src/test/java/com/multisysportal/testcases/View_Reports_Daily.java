package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.reports.DailyReports;
import com.multisysportal.utilities.TestUtil;

public class View_Reports_Daily extends TestBase {

	@Test
	public void view_Reports_Daily() throws Throwable {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("view_Reports_Daily", excel)) {
			throw new SkipException(
					"Skipping test " + "view_Reports_Daily".toUpperCase() + " with runmode exception F");
		}

		log.debug("Reports Page successsfully accessed!");
		Reporter.log("Reports Page successsfully accessed!");

		TestActions action = new TestActions();
		action.clickReports();
		DailyReports reports = action.clickReportsDaily();
		reports.selectDate();
	
	}

}
