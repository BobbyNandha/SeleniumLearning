package firstmaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import firstmaven.Reusable.Resuable;

public class ProductCatalog  extends Resuable{
	WebDriver driver;
	//constructor with WebDriver as parameter
	public ProductCatalog(WebDriver driver) {
		super(driver);//Reusable class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);//page factory driver
	}



	@FindBy(css=".mb-3")
	List<WebElement> products ;// total list of produucts
	
	
	
	@FindBy(css=".ng-animating")
	WebElement animation;//loading animation
	
	
	
	By findby=By.cssSelector(".mb-3");
	By addToCartBy=By.cssSelector(".card-body button:last-of-type");
	By msg =By.cssSelector("#toast-container");
	
	
	
	//Getting all the products in to list and returning
	public List<WebElement> productsList() {
		waiteForElementToAppear(findby);
		return products;
	
		
	}
	
	
	//Getting the web element of product by given name
	private WebElement getProductByName(String productName) {
		//filtering by using stream
		WebElement prod=productsList().stream().filter
		(prodect-> prodect.findElement(By.cssSelector("h5")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	//add to cart by passing product name
	public void addToCart(String ProductName) throws InterruptedException {
		//Getting web element and again applying find element
		getProductByName(ProductName).findElement(addToCartBy).click();
		waiteForTextToMatch(msg, "Product Added To Cart");
		//waiteForElementToInvisable(animation);
		Thread.sleep(1000);
		
	}
	
	
	
	



	
	
	
	



}
