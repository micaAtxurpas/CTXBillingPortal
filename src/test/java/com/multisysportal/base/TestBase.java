package com.multisysportal.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.multisysportal.utilities.ExcelReader;
import com.multisysportal.utilities.ExtentManager;
import com.multisysportal.utilities.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + 
			 "excel" + File.separator + "testdata.xlsx");

	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator 
			+ "excel" + File.separator + "testdata.xlsx";

	static String getUserAppDirectory() {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("mac") >= 0) {
			return System.getProperty("user.home") + File.separator + "src" + File.separator + "test" + "resources";

		}
		if (os.indexOf("win") >= 0) {
			return System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + "resources";

		} else
			return System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + "resources";
	}

	@SuppressWarnings("deprecation")
	public TestBase() {
		System.out.println("run");
		System.setProperty("userApp.root", getUserAppDirectory());

		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "properties" + File.separator + "Config.properties");
				// System.setProperty("userApp.root", ad.getUserAppDirectory());

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "properties" + File.separator + "OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Jenkins Browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			if (config.getProperty("browser").equals("firefox")) {
				// System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
				// "\\src\\test\\resources\\com\\multisys\\executables\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "executables" + File.separator + "chromedriver.exe");

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new ChromeDriver(options);
			} else if (config.getProperty("browser").equals("ie")) {

				// System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +
				// "\\src\\test\\resources\\com\\multisys\\executables\\IEDriverServer.exe");

				WebDriverManager.iedriver().setup();

				InternetExplorerOptions capabilities = new InternetExplorerOptions();
				capabilities.ignoreZoomSettings();
				driver = new InternetExplorerDriver(capabilities);

			}
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));

			
		}
	}

	public static void quit() throws InterruptedException {
		Thread.sleep(7000);
		driver.quit();

	}

	// Common Keywords
	public static void click(String locator) {
		WebElement element;

		if (locator.endsWith("_CSS")) {
			element = driver.findElement(By.cssSelector(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} else if (locator.endsWith("_XPATH")) {
			element = driver.findElement(By.xpath(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} else if (locator.endsWith("_ID")) {
			element = driver.findElement(By.id(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}

		log.debug("Clicking on an Element : " + locator);
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}

	public static void type(String locator, String value) {
		WebElement element;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		if (locator.endsWith("_CSS")) {
			element = driver.findElement(By.cssSelector(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);

		} else if (locator.endsWith("_XPATH")) {
			element = driver.findElement(By.xpath(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);

		} else if (locator.endsWith("_ID")) {
			element = driver.findElement(By.id(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);
		}

		log.debug("Typing in an Element : " + locator + " entered value as : " + value);
		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);

	}

	static WebElement dropdown;

	public void select(String locator, String value) {
		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from an element : " + locator + " value as : " + value);
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + value);

	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			TestUtil.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
					+ TestUtil.screenshotName + " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		}

	}
}