package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.Utility;

public class Base 
{
	static protected WebDriver driver;
	public  void luanchBrowser() throws InterruptedException 
	{
		driver=new ChromeDriver();
		
		driver.get("https://www.policybazaar.com/");
		
		driver.manage().window().maximize();
		
		Utility.waitsleep(1000);
		
		Reporter.log("Luanching the Browser", true);
		
	}
	
	public void closetheBrowser() throws InterruptedException
	{   
		Utility.waitsleep(2000);
		Reporter.log("Closing the Browser", true);
		driver.quit();
	}

}
