package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop=null;
	public static WebDriver driver=null;
	
	public TestBase()
	{
		FileInputStream reader;
		prop=new Properties();
		String path= System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigFiles\\data.properties";
		try {
			 reader= new FileInputStream(path);
			prop.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialize()
	{
		String strBrowser= prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
	}
	
}
