package appliedProjectListCases;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.google.common.collect.ImmutableMap;

import login.LoginPage;
import projectBase.Base;
import appliedProjectList.AppliedProjectPage;
import utils.ReadExcel;
import commonMethodes.Common;
public class AppliedProjectCases {

	WebDriver driver;
	LoginPage LoginPage;
	Common Common;
	AppliedProjectPage AppliedProjectPage;
	void setAllureEnvironment() {
		allureEnvironmentWriter(ImmutableMap.<String, String>builder()
				.put("Browser", "Chrome")
				.put("Browser.Version", "70.0.3538.77")
				.put("URL", "http://testjs.site88.net")
				.build());
	}
	private void allureEnvironmentWriter(ImmutableMap<String, String> build) {
		// TODO Auto-generated method stub

	}


	@BeforeClass
	@Parameters({ "email", "Password" })
	public void setup() {
		driver = Base.getDriver();
		LoginPage = new LoginPage(driver);
		Common = new Common(driver);
		AppliedProjectPage = new AppliedProjectPage(driver);


	}

	@AfterClass
	public void closeBrowser() {
		//LoginPage.clickLogoutBtn(); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.LogoutElementBy()));
		//driver.quit();
	}

	@Test(dataProvider = "AppliedProjectList-Verify",priority =4)
	public void AppliedProjectListCases(String TCID, String TCDescription, String expTestApplying,String expTestDuringTrade,String expTestEOT,String expTestCancelled,String expTestFailed) throws InterruptedException {
		AppliedProjectPage.clickAppliedprojectListBtn();
		Common.Wait(AppliedProjectPage.AppProjectNameBy());

		String AppliedProjectName =AppliedProjectPage.getAppProjectName();



		AppliedProjectPage.clickDuringTradBtn();
		Common.Wait(AppliedProjectPage.DuringTradeProjectNameBy());

		String DuringProjectName =AppliedProjectPage.getDuringTradeProjectName();



		AppliedProjectPage.clickEndTransactBtn();
		Common.Wait(AppliedProjectPage.EndProjectNameBy());

		String EOTProjectName =AppliedProjectPage.getEndProjectName();



		AppliedProjectPage.clickCancellTransact();
		Common.Wait(AppliedProjectPage.CancellTransactNameBy());

		String cancelledProjectName =AppliedProjectPage.getCancellTransactName();




		AppliedProjectPage.clickFailedTransacbtn();
		Common.Wait(AppliedProjectPage.FailedTransNameBy());

		String FailedProjectName =AppliedProjectPage.getFailedTransName();
		Assert.assertEquals(AppliedProjectName.trim(), expTestApplying,
				"Tesext does not match in Applying Project");

		Assert.assertEquals(DuringProjectName.trim(), expTestDuringTrade,
				"Tesext does not match in During Project");

		Assert.assertEquals(EOTProjectName.trim(), expTestEOT,
				"Tesext does not match in EOT Project");

		Assert.assertEquals(cancelledProjectName.trim(), expTestCancelled,
				"Tesext does not match in cancelled Project");

		Assert.assertEquals(FailedProjectName.trim(), expTestFailed,
				"Tesext does not match in Failed Project");
	}


	// ---------------------- DATAPROVIDERS-------------------

	@DataProvider(name = "AppliedProjectList-Verify")
	public Object[][] Apllied_projectList() {
		Object[][] AppliedList = ReadExcel.ReadTestData(this.getClass().getSimpleName(), "AppliedProjectListPage", 7);
		return AppliedList;
	}



}