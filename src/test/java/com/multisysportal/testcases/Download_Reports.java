package com.multisysportal.testcases;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;

public class Download_Reports extends TestBase {
	@Test
	public void download_Reports() throws InterruptedException {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("download_Reports", excel)) {
			throw new SkipException("Skipping test " + "download_Reports".toUpperCase() + " with runmode exception F");
		}

		Thread.sleep(2000);
		log.debug("Download Page successsfully accessed!");
		Reporter.log("Download Page successsfully accessed!");

		TestActions download_Reports = new TestActions();
		download_Reports.clickDownloadReports();

		Thread.sleep(2000);
		TestActions download_FileReports = new TestActions();
		download_FileReports.clickDownloadFileReports();

		// For FF only
		if (browser == "firefox") {
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} else {
			//DO nothing
		}

	}
}
