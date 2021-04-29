package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;

public class ResetPassword_viaForgotPassword extends TestBase{
	@Test
	public void resetPassword_viaForgotPassword() throws InterruptedException {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("resetPassword_viaForgotPassword", excel)) {
			throw new SkipException(
					"Skipping test " + "resetPassword_viaForgotPassword".toUpperCase() + " with runmode exception F");
		}

		log.debug("Forgot Password Page successsfully accessed!");
		Reporter.log("Forgot Password Page successsfully accessed!");
		
		TestActions forgotPassword = new TestActions();
		forgotPassword.clickForgotPassword();
	}
}
