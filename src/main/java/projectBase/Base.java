package projectBase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.ReadExcel;

public class Base {
	public static final String companyUrl = "https://dev-olens.aik-order.com/";
	public static WebDriver driver;
	private static final String TestDataPath = "./src/main/resources/ExcelFiles/AIK.xlsx";
	public static String sheetname;
	
	public static WebDriver getDriver() {
		return driver;
	}

	

	
	@BeforeSuite
	@Parameters("browser")
	public void initialSetup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/Chromedriver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/Firefoxdriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	
	

	@AfterSuite
	public void exitRun() {
		driver.quit();
	}

	public static WebDriver chromeSetup() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/Chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		// options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		return driver;
	}

	public static WebDriver firefoxSetup() {
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/Firefoxdriver/geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}

	public static void loadcompanyUrl(WebDriver driver) {
		driver.get(companyUrl);
	}



	public static String getTestDataPath() {
		return TestDataPath;
	}

}
