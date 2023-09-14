package firstmaven;

import org.testng.annotations.Test;

import firstmaven.TestComponents.BaseTest;

public class ProductAddingToCart extends BaseTest {
	String userEmail="naidugaru@gmail.com";
	String userPassword="May@1234";
	String productname="ADIDAS ORIGINAL";
	String productname2="IPHONE 13 PRO";
	
	@Test
	public void addingProductToValidationtest() throws Exception {

		
		
		ProductCatalog catalog = landingPage.loginApplication(userEmail, userPassword);
		catalog.addToCart(productname);
		catalog.goToCartPage();
		
		
		


	}
	
	@Test
	public void addingProducttest() throws Exception {//same as above with different product

		
		
		ProductCatalog catalog = landingPage.loginApplication(userEmail, userPassword);
		catalog.addToCart(productname2);
		catalog.goToCartPage();
		
		
		


	}


}
