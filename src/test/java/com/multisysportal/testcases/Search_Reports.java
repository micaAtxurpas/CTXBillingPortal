package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;

public class Search_Reports extends TestBase {
	@Test
	public void search_Reports() throws Exception {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("search_Reports", excel)) {
			throw new SkipException(
					"Skipping test " + "search_Reports".toUpperCase() + " with runmode exception F");
		}

		Thread.sleep(2000);
		log.debug("Search Page successsfully accessed!");
		Reporter.log("Search Page successsfully accessed!");

		TestActions enterReport = new TestActions();
		enterReport.enterSearchReport();
		
		Thread.sleep(2000);
		TestActions clickReport = new TestActions();
		clickReport.clickSearchReport();
	}
}
