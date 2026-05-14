package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.screenShot;

public class FlipKart extends BaseTest {

	@Test(enabled = false)
	void siteHome() {
		driver.get("https://www.flipkart.com");
	}

	@Test
	void searchsort() throws InterruptedException {
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//span[@role='button']")).click();

		driver.findElement(By.name("q")).sendKeys("Dostoyevsky", Keys.ENTER);

		driver.findElement(By.xpath("//span[.='Sort By']/following-sibling::div[.='Price -- Low to High']")).click();

		WebElement product = driver.findElement(By.xpath("(//img[@loading='eager'])[3]/ancestor::a"));
		screenShot.captureScreenShot(driver, "AfterSearch");

		String original = driver.getWindowHandle();
		helper.opennewtab(product);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(d -> d.getWindowHandles().size() > 1);

		for (String w : driver.getWindowHandles()) {
			if (!w.equals(original)) {
				driver.switchTo().window(w);
				break;
			}
		}
		Thread.sleep(5000);
	}

}
