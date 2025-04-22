package projectListCases;
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



import login.LoginPage;
import projectBase.Base;
import utils.ReadExcel;
import projectList.ProjectListPage;
import commonMethodes.Common;
public class ProjectListCases {
	WebDriver driver;
	LoginPage LoginPage;
	Common Common;
	ProjectListPage ProjectListPage;

	@BeforeClass
	@Parameters({ "email", "Password" })
	public void setup() {
		driver = Base.getDriver();
		LoginPage = new LoginPage(driver);
		ProjectListPage = new ProjectListPage(driver);
		Common = new Common(driver);


	}

	@AfterClass
	public void closeBrowser() {
		//LoginPage.clickLogoutBtn();  
		//wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.LogoutElementBy()));
		//driver.quit();
	}


	@Test(dataProvider = "ProjectList-Verify",priority=3)
	public void ValidProjectListCases(String TCID, String TCDescription, String expTest) throws InterruptedException {
		ProjectListPage.clickprojectListBtn();
		Common.Wait(ProjectListPage.projectNameBy());

		String ProjectName =ProjectListPage.getprojectName();

		Assert.assertEquals(ProjectName.trim(), expTest,
				"Tesext does not match");
	}


	// ---------------------- DATAPROVIDERS-------------------

	@DataProvider(name = "ProjectList-Verify")
	public Object[][] Project_List() {
		Object[][] List = ReadExcel.ReadTestData(this.getClass().getSimpleName(), "ProjectListPage", 3);
		return List;
	}



}
