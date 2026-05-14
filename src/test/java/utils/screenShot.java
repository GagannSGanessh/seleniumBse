package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screenShot {

	public static void captureScreenShot(WebDriver driver, String testName) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:/Users/gagan/eclipse-workspace/SelniumBse/target/Screenshots/" + testName + ".png");
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			System.out.println("Screenshot failed: " + e.getMessage());
		}
	}

}
