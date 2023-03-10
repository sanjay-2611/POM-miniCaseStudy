package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement gotocart;
	
	@FindBy(xpath="//tr[@class='success']")
	List<WebElement> bfdelete;
	
	@FindBy(xpath="//h3")
	WebElement price;
	
	@FindBy(xpath="//h3")
	WebElement price1;
	
	
	@FindBy(xpath="(//td[4]//a)[1]")
	WebElement delete;
	
	@FindBy(id="totalm")
	public WebElement totalm;
	
	WebDriverWait wait;
	public CartPage() 
	{
		PageFactory.initElements(driver, this);
	}
	

	public boolean delete() throws InterruptedException
	{
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		gotocart.click();
		
		String totalp=price.getText();
		int total= Integer.parseInt(totalp);
		System.out.println(total );
		delete.click();
		
		String totalp1= price1.getText();
		int total1= Integer.parseInt(totalp1);
		System.out.println(totalp1);
		
		return (total>total1);
	}
}
