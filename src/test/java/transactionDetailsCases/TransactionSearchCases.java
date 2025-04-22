package transactionDetailsCases;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commonMethodes.Common;
import login.LoginPage;
import projectBase.Base;
import transactionDetails.TransactionSearchPage;
import utils.ReadExcel;

public class TransactionSearchCases {
	WebDriver driver;
	LoginPage LoginPage;
	TransactionSearchPage TransactionSearchPage;
	Common Common;

	@BeforeClass
	@Parameters({ "email", "Password" })
	public void setup(String email, String password) {
		driver = Base.getDriver();
		//LoginPage = new LoginPage(driver);
		Common = new Common(driver);
		TransactionSearchPage = new TransactionSearchPage(driver);
		//Base.loadcompanyUrl(driver); LoginPage.login(email, password); 
		//Common.Wait(LoginPage.titleBy());



	}

	@AfterClass
	public void closeBrowser() {
		//LoginPage.clickLogoutBtn(); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.LogoutElementBy()));
		//driver.quit();
	}


	@Test(dataProvider = "TransactionSeacrh-Verify",priority=2)
	public void ValidTransactionSearchCases(String TCID, String TCDescription,String SearchValue,String Compensation,String ExpProjName,String ExpPlaceofWork,String StartYear,String StartDay,String EndYear,String EndDay) throws InterruptedException {
		TransactionSearchPage.clickTransactionListBtn();
		Common.Wait(TransactionSearchPage.TransactionTitleBy());
		TransactionSearchPage.clickSearchbutton1();
		Common.Wait(TransactionSearchPage.SearchTitleBy());
		//----------------date picker-------------

		Common.Wait(TransactionSearchPage.SearchTitleBy());

		TransactionSearchPage.SelectDate(StartYear,StartDay,EndYear,EndDay);


		Common.Wait(TransactionSearchPage.ClickDateSubmitbtnBy());
		TransactionSearchPage.ClickDateSubmitbtn();


		//----------------date picker-------------
		//-------------------------------------------value----------------------------------------------------


		TransactionSearchPage.Search(SearchValue,Compensation);
		Common.Wait(TransactionSearchPage.ResutTitleBy());

		String ProjectTitleText =TransactionSearchPage.GetProjectTitle(); String
		placeofworkText =TransactionSearchPage.GetPlaceofWork();


		Assert.assertEquals(ProjectTitleText.trim(), ExpProjName,
				"Search results  does not match woth project name");
		Assert.assertEquals(placeofworkText.trim(), ExpPlaceofWork,
				"Search results  does not match with place of work");



		//--------------------------------------------value----------------------------------



	}	




	// ---------------------- DATAPROVIDERS-------------------

	@DataProvider(name = "TransactionSeacrh-Verify")
	public Object[][] Transaction_Search() {
		Object[][] TransactionValid= ReadExcel.ReadTestData(this.getClass().getSimpleName(), "TransactionListPage", 10);
		return TransactionValid;
	}



}



