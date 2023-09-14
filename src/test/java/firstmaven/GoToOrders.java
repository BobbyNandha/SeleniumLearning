package firstmaven;

import org.testng.annotations.Test;

import firstmaven.TestComponents.BaseTest;

public class GoToOrders extends BaseTest {
	
	
	@Test
	public void goToOrders() {
		landingPage.loginApplication(prop.getProperty("username"), prop.getProperty("pass"));
	}
}
