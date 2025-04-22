package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public class DriverUtils {
	private static WebDriver driver=null;
	public void getScreenShot( ) throws IOException {
		
		Date currentdate =new Date();
		String ScreenshotName = currentdate.toString().replace(" ","-").replace(":","-");
        File SFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SFile, new File(".//screenshot//"+ScreenshotName+".png"));
        
		
	}
}


