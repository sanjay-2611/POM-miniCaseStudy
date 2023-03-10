package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class PlaceOrder extends TestBase {
	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	public WebElement placeorder;
	
	@FindBy(xpath="(//button/span[text()='×'])[3]")
	public WebElement close;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="card")
	WebElement card;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//button[text()='Purchase']")
	WebElement purchase;
	
	@FindBy(xpath="(//h2)[3]")
	public WebElement verify;
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement accept;
	
	WebDriverWait wait;
	
	public PlaceOrder()
	{
		PageFactory.initElements(driver, this);
	}
	public void confirmorder()
	
	{
		placeorder.click();
		name.sendKeys("sanjay");
		country.sendKeys("country");
		city.sendKeys("city");
		card.sendKeys("card");
		month.sendKeys("month");
		year.sendKeys("2001");
		purchase.click();
		
		
		
	}
	

}
