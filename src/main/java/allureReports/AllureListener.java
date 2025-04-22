package allureReports;
import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import projectBase.Base;
public class AllureListener implements ITestListener {
	
	
	private void takeScreenshot(WebDriver driver) {
	     Allure.addAttachment("Screenshot of failed Test Case", 
	    		 new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES))); }

	
	 
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
	     Object testClass = result.getInstance();
	     WebDriver driver = Base.getDriver();
	     if(driver instanceof WebDriver) {
	          takeScreenshot(driver);}}
	
	
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}