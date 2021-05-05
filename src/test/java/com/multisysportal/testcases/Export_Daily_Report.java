package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.reports.DailyReports;
import com.multisysportal.utilities.TestUtil;

public class Export_Daily_Report extends TestBase{
	
	@Test
	public void exportDailyReport() throws Throwable {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("Export_Daily_Report", excel)) {
			throw new SkipException(
					"Skipping test " + "Export_Daily_Report".toUpperCase() + " with runmode exception F");
		}

			log.debug("Reports exported successsfully!");
			Reporter.log("Reports exported successsfully!");

			DailyReports reports = new DailyReports();
			
			reports.selectDate();
			reports.export();
		
		}
}
