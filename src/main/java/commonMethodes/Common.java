package commonMethodes;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import login.LoginPage;
import projectBase.Base;

public class Common {
public  WebDriver  driver;
WebDriverWait wait;
//WebDriver driver = Base.firefoxSetup();
	LoginPage LoginPage;
	Common Common;



public Common(WebDriver driver) {
	this.driver = driver;
	
}



public void Wait(By element) {
	
	wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
}
	

	

}
