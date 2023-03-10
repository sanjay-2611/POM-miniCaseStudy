package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SignInPage extends TestBase {
	
	@FindBy(id="login2")
	WebElement login;
	
	@FindBy(id="loginusername")
	WebElement username;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginbtn;
	
	@FindBy(xpath="//li/a[text()='Welcome kekran']")
	public WebElement welcome;
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String user, String pass)
	
	{
		
		login.click();
		username.sendKeys(user);
		password.sendKeys(pass);
		loginbtn.click();
		//return new ();
	}
}
