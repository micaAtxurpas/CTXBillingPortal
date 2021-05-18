package com.multisysportal.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.ExcelApiTest;
import com.multisysportal.utilities.TestUtil;

@Test
public class Filter_Daily_Reports extends TestBase {

	public void filter_Daily_Reports() throws Exception {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("filter_Daily_Reports", excel)) {
			throw new SkipException(
					"Skipping test " + "filter_Daily_Reports".toUpperCase() + " with runmode exception F");
		}

		Thread.sleep(2000);
		TestActions action = new TestActions();
		action.clickReports();
		action.clickReportsDaily();

		String sheetName = "Reports";

		Thread.sleep(2000);
		ExcelApiTest eat = new ExcelApiTest(path);
		type("date_XPATH", eat.getCellData(sheetName, "Daily", 2));

	}
}
