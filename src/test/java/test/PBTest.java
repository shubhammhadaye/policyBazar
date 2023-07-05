package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pom.MyAcounttPage;
import pom.LoginPagePOM;
import utility.Utility;

public class PBTest extends Base{
     LoginPagePOM LPP;
     MyAcounttPage MAP;
    
	
	@BeforeClass
  public void openbrowser() throws InterruptedException
  {
		luanchBrowser(); 
		LPP=new LoginPagePOM(driver);
	    MAP=new MyAcounttPage(driver);
  }
	@BeforeMethod
	public void logintoPOlicyBazaar() throws EncryptedDocumentException, IOException, InterruptedException
	{   
		
	  
		LPP.clickOnHomePageSignInButton();
		Utility.waitsleep(1000);
		LPP.enterMobileNumber(Utility.readDataFromProperties("mobNo"));
		Utility.waitsleep(1000);
		LPP.clickOnSignInWithPassword();
		Utility.waitsleep(1000);
		LPP.enterPassword(Utility.readDataFromProperties("pwd"));
		Utility.waitsleep(1000);
		LPP.clickOnSignInButton();
		Utility.waitsleep(1000);
		LPP.clickOnMyAccountButton();
		Utility.waitsleep(1000);
		LPP.clickOnMyProfileButton();
		
		// switch to new tab
		  
		Set<String> allID = driver.getWindowHandles();
		List<String> wh=new ArrayList<>(allID);
		driver.switchTo().window(wh.get(1));
		
	}
	
	@Test
	  public void verifyUserName() throws EncryptedDocumentException, IOException, InterruptedException 
	  {     Utility.waitsleep(1000);
			String actoutput=MAP.validateUserName();
			String expOutput=Utility.readDataFromProperties("un");
			
	   Assert.assertEquals(actoutput, expOutput,"Actual Output and Expected Ouput are not Matched, TC is failed");
	 }
//	@Test
//	 public void verifyemail() throws EncryptedDocumentException, IOException, InterruptedException 
//	  {      UtilityClass.waitsleep(1000);
//			String acotput=MAP.validatemailid();
//			String epotput=UtilityClass.readDataFromProperties("email");
//			
//	   Assert.assertEquals(acotput, epotput,"Actual Output and Expected Ouput are not Matched, TC is failed");
//	 }
	
	
	@AfterMethod
	public void logoutFromPolicyBazar() throws InterruptedException
	{   
		Utility.waitsleep(1000);
		MAP.clickOnLogoutButton();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{   
		Utility.waitsleep(1000);
		closetheBrowser();
	}
}
