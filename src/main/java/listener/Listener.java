package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		Reporter.log("This test " + result.getName() + "failed, pl try again", true);
	}
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("This TC" + result.getName() +"plz check dependend method", true);
	}
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("This" + result.getName() +" excecution started", true);
	}
    public void onTestStart(ITestResult result) 
    {
    	Reporter.log("This" + result.getName() +" method completed sucessfully", true);
    }
}
