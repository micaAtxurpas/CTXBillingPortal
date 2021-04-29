package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;


public class Login_BillingPortal extends TestBase {

	@Test
	public void login_BillingPortal() throws Exception {

		if (!TestUtil.isTestRunnable("Login_BillingPortal", excel)) {
			throw new SkipException("Skipping the test " + "Login_BillingPortal" + " as the Run mode is NO");
		}
		
		
		log.debug("Sign In Page successsfully accessed!");
		Reporter.log("Sign In Page successsfully accessed!");

		TestActions signin = new TestActions();
		signin.enterLoginCredentials();
		signin.clickSignIn();

	}
	
//	//04-28-2021 Mai; Other scenario: TestActions class not applicable
//	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
//	public void login_BillingPortal(Hashtable<String, String> data) throws InterruptedException {
//
//		// for excel run mode test suites
//		if (!TestUtil.isTestRunnable("login_BillingPortal", excel)) {
//			throw new SkipException("Skipping test " + "login_BillingPortal".toUpperCase() + " with runmode exception F");
//		}
//
//		log.debug("Sign In Page successsfully accessed!");
//		Reporter.log("Sign In Page successsfully accessed!");
//
//		type("fieldEmail_XPATH", data.get("email"));
//		type("fieldPassword_XPATH",  data.get("password".toString()));
//
////		int temp2 = 1;
////		signin.clickSignIn2(temp2);
//	}

}
