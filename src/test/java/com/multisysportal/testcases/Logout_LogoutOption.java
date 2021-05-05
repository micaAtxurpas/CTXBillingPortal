package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;

public class Logout_LogoutOption extends TestBase {
	@Test
	public void logout_LogoutOption() throws InterruptedException {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("logout_LogoutOption", excel)) {
			throw new SkipException(
					"Skipping test " + "logout_LogoutOption".toUpperCase() + " with runmode exception F");
		}
		
		Thread.sleep(2000);
		log.debug("Logout Page successsfully accessed!");
		Reporter.log("Logout Page successsfully accessed!");

		TestActions logout_Username = new TestActions();
		logout_Username.clickUsername();
		
		Thread.sleep(2000);
		TestActions logout_LogoutOption = new TestActions();
		logout_LogoutOption.clickLogoutOption();
	}
}
