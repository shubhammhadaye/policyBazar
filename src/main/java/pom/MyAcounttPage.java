package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAcounttPage 
{
	
	//variables
	
	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']")private WebElement userName;
	
	@FindBy(xpath = "//input[@name='email']")private WebElement emailid;
	
	@FindBy(xpath = "//div[@class='h_l']")private WebElement logoutButton;
	
	//constructor
	
public MyAcounttPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

// methods

public String validateUserName()
{
	String actOutput=userName.getText();
	return actOutput;
	
	
}
	public String validatemailid()
	{    
		String actemailid=emailid.getText();
		return actemailid;
		
		
	}
	
	public void clickOnLogoutButton()
	{
		logoutButton.click();
	}


}
