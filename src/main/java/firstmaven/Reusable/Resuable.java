package firstmaven.Reusable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resuable {
	WebDriver driver;
	WebDriverWait waite;
	//constructor with WebDriver as parameter from all the classes extending this class
	public Resuable(WebDriver driver) {
		this.driver = driver;
		waite=new WebDriverWait(driver,Duration.ofSeconds(5)); //timeout driver
		PageFactory.initElements(driver, this); //page factory driver

	}
	
	@FindBy(css="[routerlink*=cart]")
	WebElement goTOCart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement goToOrders;
	
	



	public void waiteForElementToAppear(By findby) {
		waite.until(ExpectedConditions.visibilityOfElementLocated(findby));


	}
	
	public void waiteForWebElementToAppear(WebElement findby) {
		waite.until(ExpectedConditions.visibilityOf(findby));


	}

	public void waiteForTextToMatch(By msg, String textToMatch) {
		waite.until(ExpectedConditions.textToBePresentInElementLocated(msg, textToMatch));

	}

	public void waiteForElementToInvisable(WebElement animation) {
		waite.until(ExpectedConditions.invisibilityOf(animation));


	}
	//common link
	public void goToCartPage() {
		goTOCart.click();
		
	}
	
	
}
