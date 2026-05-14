package listner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShot {

    public static String captureScreenShot(
            WebDriver driver,
            String testName) {

        String screenshotDir =
                System.getProperty("user.dir")
                + "/test-output/screenshots/";

        try {

            Files.createDirectories(Paths.get(screenshotDir));

            File srcFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String screenshotPath =
                    screenshotDir
                    + testName
                    + "_"
                    + System.currentTimeMillis()
                    + ".png";

            File destFile = new File(screenshotPath);

            FileUtils.copyFile(srcFile, destFile);

            return screenshotPath;

        } catch (IOException e) {

            e.printStackTrace();

            return null;
        }
    }
}