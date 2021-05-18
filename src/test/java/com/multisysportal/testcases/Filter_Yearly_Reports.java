package com.multisysportal.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.ExcelApiTest;
import com.multisysportal.utilities.TestUtil;

@Test
public class Filter_Yearly_Reports extends TestBase {

	public void filter_Yearly_Reports() throws Exception {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("filter_Yearly_Reports", excel)) {
			throw new SkipException(
					"Skipping test " + "filter_Yearly_Reports".toUpperCase() + " with runmode exception F");
		}

		Thread.sleep(2000);
		TestActions action = new TestActions();
		action.clickReports();
		action.clickReportsYearly();

		String sheetName = "Reports";

		Thread.sleep(2000);
		ExcelApiTest eat = new ExcelApiTest(path);
		select("yyear_XPATH", eat.getCellData(sheetName, "Yearly", 2));

	}

}
