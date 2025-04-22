package projectList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectListPage {
	private WebDriver driver;
	private By projectListBtn = By.xpath("//a[contains(@href,'/company/projectList')]");
	private By projectNameElement = By.xpath("//tbody/tr/td[1]/table/tbody/tr[1]/td");
	
	
	

	public ProjectListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickprojectListBtn() {
		driver.findElement(projectListBtn).click();
	}
	
	
	

	
	  public By projectNameBy() { 
		  return projectNameElement; 
	  }
	 
	
	
	public String getprojectName() {
		String name = driver.findElement(projectNameElement).getText().trim();
		return name;
	}
	
	

	

}
