package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;

public class View_Dashboard extends TestBase {

	@Test
	public void view_Dashboard() throws InterruptedException {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("view_Dashboard", excel)) {
			throw new SkipException("Skipping test " + "view_Dashboard".toUpperCase() + " with runmode exception F");
		}

		Thread.sleep(2000);
		log.debug("Dashboard Page successsfully accessed!");
		Reporter.log("Dashboard Page successsfully accessed!");

		TestActions viewDashboard = new TestActions();
		viewDashboard.clickDashboard();

		TestActions viewTotalTransactions = new TestActions();
		viewTotalTransactions.clickPrevTotalTrans();
		Thread.sleep(2000);
		viewTotalTransactions.clickPrevTotalTrans();
		Thread.sleep(2000);
		viewTotalTransactions.clickNextTotalTrans();
		Thread.sleep(2000);
		viewTotalTransactions.clickNextTotalTrans();
		Thread.sleep(2000);

		TestActions viewComparative = new TestActions();
		viewComparative.clickDashboardInviYYYY();
		Thread.sleep(2000);
		viewComparative.clickDashboardVisYYYY();
	}

}
