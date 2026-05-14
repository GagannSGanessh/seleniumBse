package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listner.TestListener;



@Listeners(TestListener.class)
public class FlipKart extends BaseTest {

	@Test(enabled = false)
	void siteHome() {
		getDriver().get("https://www.flipkart.com");
	}

	@Test
	void searchsort() throws InterruptedException {
		getDriver().get("https://www.flipkart.com");
		getDriver().findElement(By.xpath("//span[@role='button']")).click();

		getDriver().findElement(By.name("q")).sendKeys("Dostoyevsky", Keys.ENTER);

		getDriver().findElement(By.xpath("//span[.='Sort By']/following-sibling::div[.='Price -- Low to High']")).click();

		WebElement product = getDriver().findElement(By.xpath("(//img[@loading='eager'])[3]/ancestor::a"));

		String original = getDriver().getWindowHandle();
		helper.opennewtab(product);

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		wait.until(d -> d.getWindowHandles().size() > 1);

		for (String w : getDriver().getWindowHandles()) {
			if (!w.equals(original)) {
				getDriver().switchTo().window(w);
				break;
			}
		}
		Thread.sleep(5000);
	}

}
