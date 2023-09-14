package firstmaven.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import firstmaven.LandingPage;

public class BaseTest {
	WebDriver driver;
	public LandingPage landingPage;
	public Properties prop;

	//main web driver initialization
	public WebDriver initializeDriver() throws Exception {
		prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\Dell\\ecl\\firstmaven\\src\\test\\java\\firstmaven\\file.properties");
		prop.load(file);

		//String browser=prop.getProperty("browser");
		String browser=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser"); //to get browser propery from maven cmd using terinary
		ChromeOptions options =new ChromeOptions();
		if(browser.contains("headless")) {
		options.setHeadless(true);
		}

		if(browser.contains("chrome")) {
			driver=new ChromeDriver(options);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		//Implicit timeout
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod //opening web page
	public LandingPage lanchApplication() throws Exception {
		driver=initializeDriver(); //Calling method in same class
		landingPage=new LandingPage(driver);//Calling method by creation of object
		landingPage.goTo();
		return landingPage;	
	}
	@AfterMethod
	public void driverClose() {
		driver.quit();

	}

	public static String getScreenshot(String testcasename, WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;//driver initial
		String filepath="./reports/"+testcasename+".png";

		//File source=(TakesScreenshot) driver.getScreenshotAs(OutputType.FILE);
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(filepath);
		try {
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		return filepath;

	}


}
