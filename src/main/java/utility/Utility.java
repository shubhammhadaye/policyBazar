package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
             
     // ScreenShot          
	public void takeScreenshot(WebDriver driver , String filename) throws IOException
	{
		File value = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\RohitK\\Desktop\\shubham\\ScreenShot\\"+filename+".png");
		
		FileHandler.copy(value, dest);
		
		Reporter.log("Taking ScreenShot", true);
	}
	
	// Scrolling
	public void scrollView(WebDriver driver ,WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",element );
		
		Reporter.log("Scrolling into view", true);
	}
	
	// Read data from Excel
	public static String readDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException 
	{
          Reporter.log("Reading data from excel sheet", true);
		
		FileInputStream myFile=new FileInputStream("C:\\Users\\RohitK\\Desktop\\shubham\\Selenium Excel File\\familydata.xlsx");
		
		String value = WorkbookFactory.create(myFile).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
		return value;
	}
	
	// wait
	
	public static void waitsleep ( int waittime) throws InterruptedException
	{
		Thread.sleep(waittime);
		
		Reporter.log("waiting for"+waittime+"mili sec", true);
		
	}
	
	
	//Read Data from Properties
	
	public static String readDataFromProperties(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myFile=new FileInputStream("C:\\Users\\RohitK\\eclipse-workspace\\projectSeleniumstudy\\PolicyBazar.properties");
		prop.load(myFile);
	    String value = prop.getProperty(key);
		Reporter.log("Read Data "+key+"from Properties ", true);
		return value;
		
	}
	
	
}
