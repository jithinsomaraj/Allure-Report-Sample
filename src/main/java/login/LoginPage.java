package login;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private By emailfield = By.id("formGroupUserNameInput");
	private By passwordfield = By.id("formGroupPasswordInput");
	private By loginBtn = By.xpath("//*[@class='btn btn-login-security btn-lg btn-block my-2 text-white font-weight-bold']");
	private By title = By.xpath("//*[@class='text-center text_type_green mb_M']");
	private By LogoutBtn =By.xpath("//*[@id=\"footer\"]//*[text()='ログアウト']");
	private By LogoutElement =By.xpath("//*[@class='card-header font-weight-bold form-title security']");
	private By LoginValidationMsg=By.xpath("//p[@class='text-danger mb_S']");



	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(emailfield);
	}

	public WebElement getPassword() {
		return driver.findElement(passwordfield);
	}

	public void clickloginbtn() {
		driver.findElement(loginBtn).click();
	}

	public By loginbtnBy() {
		return loginBtn;
	}
	public By titleBy() {
		return title;
	}

	public String GettitleText() {
		String titleText = driver.findElement(title).getText().trim();
		return titleText;
	}





	public void login(String email, String password) {
		this.getEmail().sendKeys(email);
		this.getPassword().sendKeys(password);
		this.clickloginbtn();
	}

	public void clickLogoutBtn() {
		driver.findElement(LogoutBtn).click();
	}
	
	public By LoginValidationMsgBy() {
		return LoginValidationMsg;
	}
	
	public String GetErrorMsg() {
		String Text = driver.findElement(LoginValidationMsg).getText().trim();
		return Text;
	}
	
	

	public By LogoutElementBy() {
		return LogoutElement;
	}

}
