package com.multisysportal.testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.multisysportal.base.TestActions;
import com.multisysportal.base.TestBase;
import com.multisysportal.utilities.TestUtil;

public class View_Map extends TestBase {
	@Test
	public void view_Map() {

		// for excel run mode test suites
		if (!TestUtil.isTestRunnable("view_Map", excel)) {
			throw new SkipException("Skipping test " + "view_Map".toUpperCase() + " with runmode exception F");
		}

		log.debug("Map Page successsfully accessed!");
		Reporter.log("Map Page successsfully accessed!");

		TestActions view_Map = new TestActions();
		view_Map.clickMap();
	}
}
