	package com.multisysportal.base;


import com.multisysportal.reports.CustomReports;
import com.multisysportal.reports.DailyReports;
import com.multisysportal.reports.MonthlyReports;
import com.multisysportal.reports.YearlyReports;
import com.multisysportal.utilities.ExcelApiTest;

public class TestActions extends TestBase {

	// Login_BillingPortal
	public void enterLoginCredentials() throws Exception {
		String sheetName = "Login";
		ExcelApiTest eat = new ExcelApiTest(path);

		type("fieldEmail_XPATH", eat.getCellData(sheetName, "Email", 2));
		type("fieldPassword_XPATH", eat.getCellData(sheetName, "Password", 2));

	}

	public void clickSignIn() {
		click("btnSignIn_XPATH");
	}

	// View_Dashboard
	public void clickDashboard() {
		click("menuDashboard_XPATH");
	}

	public void clickPrevTotalTrans() {
		click("btnPrevTotalTransaction_XPATH");
	}

	public void clickNextTotalTrans() {
		click("btnNextTotalTransaction_XPATH");
	}

	public void clickDashboardInviYYYY() {
		click("menuDashboardYYYY1_XPATH");
		click("menuDashboardYYYY2_XPATH");
		click("menuDashboardYYYY3_XPATH");
		click("menuDashboardYYYY4_XPATH");
		click("menuDashboardYYYY5_XPATH");
		click("menuDashboardYYYY6_XPATH");
	}

	public void clickDashboardVisYYYY() {
		click("menuDashboardYYYY1_XPATH");
		click("menuDashboardYYYY2_XPATH");
		click("menuDashboardYYYY3_XPATH");
		click("menuDashboardYYYY4_XPATH");
		click("menuDashboardYYYY5_XPATH");
		click("menuDashboardYYYY6_XPATH");
	}

	// View_Reports
	public void clickReports() {
		click("menuReports_XPATH");
	}

	// View_Reports_Daily
	public DailyReports clickReportsDaily() {
		click("menuReportsDaily_XPATH");
		return new DailyReports();
	}
	
	// View_Reports_Monthly
	public MonthlyReports clickReportsMonthly() {
		click("menuReportsMonthly_XPATH");
		
		return new MonthlyReports();
	}

	// View_Reports_Yearly

	public YearlyReports clickReportsYearly() {
		click("menuReportsYearly_XPATH");
		return new YearlyReports();
	}
	

	// View_Reports_Custom
	public CustomReports clickReportsCustom() {
		click("menuReportsCustom_XPATH");
		return new CustomReports();
	}
	
	

	// Search_Reports
	public void enterSearchReport() throws Exception {
		String sheetName = "SearchRep";
		ExcelApiTest eat = new ExcelApiTest(path);

		type("fieldSearchReport_XPATH", eat.getCellData(sheetName, "ReportName", 2));
	}

	public void clickSearchReport() {
		click("btnSearchReport_XPATH");
	}
	
	// Export_Daily_Reports
	public void clickExportReportDaily() {
		click("btnExportReportsDaily_XPATH");
	}

	// Download_Reports
	public void clickDownloadReports() {
		click("menuDownload_XPATH");
	}

	public void clickDownloadFileReports() {
		click("btnDownloadFile_XPATH");
	}

	// View_Map
	public void clickMap() {
		click("menuMap_XPATH");
	}

	// View_Profile & // Logout_LogoutOption
	public void clickUsername() {
		click("btnUsername_XPATH");
	}
	
	// View_Profile
	public void clickProfileOption() {
		click("ddProfileOption_XPATH");
	}

	// Logout_LogoutOption
	public void clickLogoutOption() {
		click("ddLogoutOption_XPATH");
	}

	// ResetPassword_viaForgotPassword
	public void clickForgotPassword() {
		click("forgotpassword_XPATH");
	}
	
	public void selectRepDate() {
		click("dpRepDailyDate_CSS");
	}

}
