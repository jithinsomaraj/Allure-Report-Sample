package appliedProjectList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppliedProjectPage {
	private WebDriver driver;
	private By AppprojectListBtn = By.xpath("//a[contains(@href,'/company/appliedprojectlist')]");
	private By ApplyingNameElement = By.xpath("//tr/td[1]/table/tbody/tr[1]/td");
	private By DuringTradBtnElm =By.xpath("//*[@id=\"category2-tab\"]");
	private By DurTradeNameElement = By.xpath("//*[@id=\"category2\"]/table/tbody/tr[1]/td[1]/table/tbody/tr[1]/td");
	private By EndTransactBtnElm =By.xpath("//*[@id=\"category3-tab\"]");
	private By EndTransactNAmeElm =By.xpath("//*[@id=\"category3\"]/table/tbody/tr[1]/td[1]/table/tbody/tr[1]/td");
	private By TransCancelledElm =By.xpath("//*[@id=\"category4-tab\"]");
	private By TransCancellNameElm =By.xpath("//*[@id=\"category4\"]/table/tbody/tr[1]/td[1]/table/tbody/tr[1]/td");
	private By FailedTransacElm =By.xpath("//a[contains(@href,'#category5')]");
	private By FailedTransNameElm =By.xpath("//*[@id=\"category5\"]/table/tbody/tr[1]/td[1]/table/tbody/tr[1]/td");
	
	
	

	public AppliedProjectPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAppliedprojectListBtn() {
		driver.findElement(AppprojectListBtn).click();
	}
	
	
	

	
	  public By AppProjectNameBy() { 
		  return ApplyingNameElement; 
	  }
	 
	
	
	public String getAppProjectName() {
		String name = driver.findElement(ApplyingNameElement).getText().trim();
		return name;
	}
	
	public void clickDuringTradBtn() {
		driver.findElement(DuringTradBtnElm).click();
	}
	
	
	

	
	  public By DuringTradeProjectNameBy() { 
		  return DurTradeNameElement; 
	  }
	 
	
	
	public String getDuringTradeProjectName() {
		String name = driver.findElement(DurTradeNameElement).getText().trim();
		return name;
	}
	
	public void clickEndTransactBtn() {
		driver.findElement(EndTransactBtnElm).click();
	}
	
	
	

	
	  public By EndProjectNameBy() { 
		  return EndTransactNAmeElm; 
	  }
	 
	
	
	public String getEndProjectName() {
		String name = driver.findElement(EndTransactNAmeElm).getText().trim();
		return name;
	}
	
	
	public void clickCancellTransact() {
		driver.findElement(TransCancelledElm).click();
	}
	
	
	

	
	  public By CancellTransactNameBy() { 
		  return TransCancellNameElm; 
	  }
	 
	
	
	public String getCancellTransactName() {
		String name = driver.findElement(TransCancellNameElm).getText().trim();
		return name;
	}
	
	public void clickFailedTransacbtn() {
		driver.findElement(FailedTransacElm).click();
	}
	
	
	

	
	  public By FailedTransNameBy() { 
		  return FailedTransNameElm; 
	  }
	 
	
	
	public String getFailedTransName() {
		String name = driver.findElement(FailedTransNameElm).getText().trim();
		return name;
	}

	

}