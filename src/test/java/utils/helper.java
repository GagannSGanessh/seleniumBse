package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class helper {
	WebDriver driver;
	Actions action;

	public helper(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
	}

//open new tab	

	public void opennewtab(WebElement element) {
		((JavascriptExecutor) driver)
	    .executeScript("window.open(arguments[0].href,'_blank');", element);}

}
