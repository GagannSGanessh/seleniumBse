package base;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.helper;

public class BaseTest {
//	public static WebDriver driver;
	public helper helper;
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	@BeforeMethod
	public void setup() {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");
		driver.set(new ChromeDriver(options));
		helper = new helper(getDriver());
		
		 getDriver().manage().window().maximize();
		 getDriver() .manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	   public WebDriver getDriver() {
	        return driver.get();
	    }
	public static String getBase64Screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
	@AfterMethod
	public void teardown() {
		if (driver != null) {
			getDriver().quit();
		}
	}

}
