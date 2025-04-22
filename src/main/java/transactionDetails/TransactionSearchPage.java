package transactionDetails;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TransactionSearchPage {


	private WebDriver driver;
	private By TransactionListBtn = By.xpath("//a[contains(@href,'/company/transactionList')]");
	private By TransactionTitle = By.cssSelector("#transactions > div > div > div.col-12.mt_L > h1");
	private By Searchbutton1 =By.id("search_button");
	private By SearchTitle =By.cssSelector("#search_content > div > div.search_content-title > p");
	private By SearchDate =By.cssSelector("#search-date");
	private By CalenderYearLeft =By.xpath("//*[@class='drp-calendar left']//*[@class='yearselect']");
	public String CalenderDayLeft_BeforeXpath ="//*[@class=\"drp-calendar left\"]//*[(text()='";
	public String CalenderDayLeft_AfterXpath="')][not(contains(@class,\"off ends available\"))]";
	private By CalenderYearRight =By.xpath("//*[@class='drp-calendar right']//*[@class='yearselect']");
	public String CalenderDayRight_BeforeXpath ="//*[@class=\"drp-calendar right\"]//*[(text()='";
	public String CalenderDayRight_AfterXpath="')][not(contains(@class,\"off ends available\"))]";
	private By DatEConfirmBtn =By.xpath("//*[@class='applyBtn btn btn-default btn-small btn-primary']");
	private By Searchfield =By.xpath("//input[@name='search_text']");
	private By compensationfield =By.xpath("//input[@name='search_reward_amount']");
	private By SearchButton2=By.xpath("//*[@class='btn_type_navy_blue']");
	private By ResutTitle=By.xpath("//*[@class='table table-striped mb_M']//*[text()='日付']");
	private By ProjectTitle=By.xpath("//tbody/tr[1]/td[2]"); //project name
	private By PlaceofWork=By.xpath("//tbody/tr[1]/td[4]");
	public TransactionSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickTransactionListBtn() {
		driver.findElement(TransactionListBtn).click();
	}

	public By TransactionTitleBy() { 
		return TransactionTitle; 
	}

	public void ClickDatePicker() {
		driver.findElement(SearchDate).click();
	}

	public void ClickCalenderYearLeft() {
		driver.findElement(CalenderYearLeft).click();
	}

	public void ClickCalenderYearRight() {
		driver.findElement(CalenderYearRight).click();
	}



	public void SelectDate(String Startyear,String StartDay,String Endyear,String EndDay) throws InterruptedException  {
		Thread.sleep(3000);
		this.ClickDatePicker();
		Thread.sleep(3000);

		Select objSelect =new Select(driver.findElement(CalenderYearLeft));
		objSelect.selectByVisibleText(Startyear);
		String i = StartDay; 
		WebElement StrtDay=driver.findElement(By.xpath(CalenderDayLeft_BeforeXpath+i+CalenderDayLeft_AfterXpath)); 
		StrtDay.click();
		Select objSelect1 =new Select(driver.findElement(CalenderYearRight));
		objSelect1.selectByVisibleText(Endyear);
		String j = EndDay; 
		WebElement Days=driver.findElement(By.xpath(CalenderDayRight_BeforeXpath+i+CalenderDayRight_AfterXpath));
		Days.click();






	}



	public By ClickDateSubmitbtnBy() { 
		return DatEConfirmBtn; 
	}

	public void ClickDateSubmitbtn() {
		driver.findElement(DatEConfirmBtn).click();
	}



	public WebElement getSearchfield() {
		return driver.findElement(Searchfield);
	}


	public WebElement getcompensationfield() {
		return driver.findElement(compensationfield);
	}

	public void ClickSearchButton2() {
		driver.findElement(SearchButton2).click();
	}	

	public void clickSearchbutton1() {
		driver.findElement(Searchbutton1).click();
	}


	public By SearchTitleBy() { 
		return SearchTitle; 
	}

	public void SearchTExt(String SearchValue) {
		driver.findElement(Searchfield).sendKeys(SearchValue);
	}

	public void compensation(String Compensation) {
		driver.findElement(compensationfield).sendKeys(Compensation);
	}

	public void clickSearchbutton2() {
		driver.findElement(SearchButton2).click();
	}


	public void Search(String value,String Compensation) {
		this.getSearchfield().sendKeys(value);
		this.getcompensationfield().sendKeys(Compensation);
		this.ClickSearchButton2();
	}

	public By ResutTitleBy() { 
		return ResutTitle; 
	}

	public String GetPlaceofWork() {
		String titleText = driver.findElement(PlaceofWork).getText().trim();
		return titleText;
	}

	public String GetProjectTitle() {
		String titleText = driver.findElement(ProjectTitle).getText().trim();
		return titleText;
	}





}
