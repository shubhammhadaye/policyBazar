package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM
{
	
	//variable
	
      @FindBy(xpath = "//a[@class='sign-in']")private WebElement signInButtonHomePage;
      
      @FindBy(xpath = "(//input[@type='number'])[2]")private WebElement mobileNumberField;
      
      @FindBy(xpath = "(//span[text()='Sign in with Password'])[2]")private WebElement signInWithPassword;
      
      @FindBy(xpath = "//input[@id='central-login-password']")private WebElement passwordField;
      
      @FindBy(xpath = "//span[text()='Sign in']")private WebElement signInButton;
      
      @FindBy(xpath = "//div[@class='userprofile']")private WebElement myAccountButton;
      
      @FindBy(xpath = " //span[text()=' My profile ']")private WebElement myProfilrButton;



// Constructor

public LoginPagePOM(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}	


//Methods

public void clickOnHomePageSignInButton()
{
	signInButtonHomePage.click();
}

public void enterMobileNumber(String mobno)
{
	mobileNumberField.sendKeys(mobno);
}

public void clickOnSignInWithPassword()
{
	signInWithPassword.click();
}

public void enterPassword(String pwd)
{
	passwordField.sendKeys(pwd);
}

public void clickOnSignInButton()
{
	signInButton.click();
}

public void clickOnMyAccountButton()
{
	myAccountButton.click();
}

public void clickOnMyProfileButton()
{
	myProfilrButton.click();
}





















}
