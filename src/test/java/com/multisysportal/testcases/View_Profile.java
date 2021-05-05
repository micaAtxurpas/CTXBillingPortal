package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;

public class View_Profile extends TestBase {

	@Test
	public void view_Profile() throws InterruptedException {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("view_Profile", excel)) {
			throw new SkipException("Skipping test " + "view_Profile".toUpperCase() + " with runmode exception F");
		}

		Thread.sleep(2000);
		log.debug("Profile Page successsfully accessed!");
		Reporter.log("Profile Page successsfully accessed!");
		
		TestActions logout_Username = new TestActions();
		logout_Username.clickUsername();
		
		Thread.sleep(2000);
		TestActions profile_Username = new TestActions();
		profile_Username.clickProfileOption();
		
	}
}
