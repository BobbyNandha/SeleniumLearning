package firstmaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import firstmaven.Reusable.Resuable;

public class LandingPage extends Resuable {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}





	@FindBy(id="userEmail")
	WebElement useremail;

	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement submitbutton;
	
	@FindBy(css="[class*='flyInOut']") WebElement errorMessage;
	
	
	
	//go to url method
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
		
	}
	//login to application method 
	public ProductCatalog loginApplication(String userEmail,String password) {
		useremail.sendKeys(userEmail);
		userpassword.sendKeys(password);
		submitbutton.click();
		return new ProductCatalog(driver);
		
	}
	
	
	//login error msg
	public String getErrorMessage() {
		waiteForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
		
	}
	
	
	
	



}
