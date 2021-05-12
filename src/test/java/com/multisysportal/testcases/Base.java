package com.multisysportal.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;

import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;

public class Base extends TestBase{
	
	
	@AfterSuite
	public void tearDown() throws InterruptedException{
		if (!TestUtil.isTestRunnable("Base", excel)) {
			throw new SkipException(
					"Skipping test " + "Base".toUpperCase() + " with runmode exception F");
		}
		
		
		TestBase.quit();
		
	}
	
	//Just to test Jenkins job schedule run
	

}
