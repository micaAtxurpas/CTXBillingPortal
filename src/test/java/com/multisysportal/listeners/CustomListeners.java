package com.multisysportal.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {

		// to start test cases for extent reports
		test = rep.startTest(result.getName().toUpperCase());

		// for excel run mode test suites
		// transferred to per test cases
//		if (!TestUtil.isTestRunnable(result.getName(), excel)) {
//			throw new SkipException("Skipping test " +result.getName().toUpperCase()+" with runmode exception F");
//		}

	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase() + " PASS");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestFailure(ITestResult result) {

		// to handle screenshots for failed test cases
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// to log extent reports
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + "FAILURE with exception " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		// to log reportNg
		Reporter.log("Screenshot error attached, click for full view.");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");

		rep.endTest(test);
		rep.flush();

	}

	public void onTestSkipped(ITestResult result) {

		// for excel run mode test suites
		test.log(LogStatus.SKIP, result.getName().toUpperCase() + " Skipped the test as the run mode is F");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
