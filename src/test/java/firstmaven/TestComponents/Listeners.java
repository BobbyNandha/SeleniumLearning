package firstmaven.TestComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import firstmaven.resources.ExtentReportsObject;

public class Listeners  implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReportsObject.Reports();
	WebDriver driver;

	@Override
	public  void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
	}



	@Override
	public  void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test passed");

	}

	@Override
	public  void  onTestFailure(ITestResult result) {
//		 try {
//				 driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
		test.fail(result.getThrowable());
		//take screenshot
		//String filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		//test.addScreenCaptureFromPath(filepath);
		//System.out.println(result.getMethod().getMethodName()+driver.getTitle());
		
		

	}
	@Override
	public  void onFinish(ITestContext context) {
		extent.flush();
		
	
	    
	  }






}
