package com.multisysportal.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.ExcelApiTest;
import com.multisysportal.utilities.TestUtil;

@Test
public class Filter_Monthly_Reports extends TestBase {

	public void filter_Monthly_Reports() throws Exception {

		

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("filter_Monthly_Reports", excel)) {
			throw new SkipException(
					"Skipping test " + "filter_Monthly_Reports".toUpperCase() + " with runmode exception F");
		}

		Thread.sleep(2000);
		TestActions action = new TestActions();
		action.clickReports();
		action.clickReportsMonthly();

		String sheetName = "Reports";

		Thread.sleep(2000);
		ExcelApiTest eat = new ExcelApiTest(path);
		select("month_XPATH", eat.getCellData(sheetName, "Monthly", 2));
		select("myear_XPATH", eat.getCellData(sheetName, "Monthly", 3));

	}

}
