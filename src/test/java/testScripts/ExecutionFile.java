package testScripts;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Pages.AddToCart;
import Pages.CartPage;
import Pages.PlaceOrder;
import Pages.SignInPage;
import base.TestBase;

public class ExecutionFile extends TestBase {
	SignInPage login;
	AddToCart add;
	CartPage cart;
	PlaceOrder order;
	WebDriverWait wait;
	
	@BeforeTest
	public void startup()
	{
		initialize();
	}
	
	
	@Test(priority=1)
	public void purchase()
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		login=new SignInPage();
		login.login(prop.getProperty("uname"), prop.getProperty("pass"));
//		wait.until(ExpectedConditions.stalenessOf(login.welcome));
		Assert.assertEquals(login.welcome.getText(),"Welcome kekran");			
	}
	
	@Test(dataProvider="data",priority=2)
	
	public void additem(String item)
	
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		add= new AddToCart();
		
		add.search(item);
		add.GoTOCart();
		boolean flag=false;
		for(WebElement cartslist: add.items)
		  {
			  if(cartslist.getText().equalsIgnoreCase(item)) {
			  Assert.assertEquals(cartslist.getText(), item);
			  flag=true;
			  }			  
		  }
		Assert.assertTrue(flag);	  
	}

	@Test(priority=3)
	public void delete() throws InterruptedException
	{
		cart=new CartPage();
		order=new PlaceOrder();
		boolean success= cart.delete();
		Assert.assertTrue(success);
	}
	
	@Test(priority=4)
	public void placeorder()
	{
		order=new PlaceOrder();
		order.confirmorder();
		Assert.assertEquals(order.verify.getText(), "Thank you for your purchase!");
		order.accept.click();
		
	}
	
	 @DataProvider(name="data")
	  public Object[][] ProListCSV() throws CsvValidationException, IOException{
		  String path=System.getProperty("user.dir")+"//src//test//resources//testData//singledata.csv";
		  String[] cols;
		  CSVReader reader = new CSVReader(new FileReader(path));
		  ArrayList<Object> dataList=new ArrayList<Object>();
		  while((cols=reader.readNext())!=null)
		  {
			  Object[] record= {cols[0]};
			  dataList.add(record);
		  }
		  return dataList.toArray(new Object[dataList.size()][]);
		  
	  }
	

}
