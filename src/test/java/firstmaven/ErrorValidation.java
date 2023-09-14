package firstmaven;

import org.testng.Assert;
import org.testng.annotations.Test;

import firstmaven.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
	@Test(retryAnalyzer = firstmaven.TestComponents.RetryTest.class)
	public void inCorrectLoginErrorValidationtest() throws Exception {

		


		landingPage.loginApplication(prop.getProperty("wrongusername") , "wrongpass");
		Assert.assertEquals("Incorrect email or password", landingPage.getErrorMessage());
		
	}}
