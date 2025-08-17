package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        // Timestamp format: yyyyMMdd_HHmmss
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Create unique screenshot name
        String fileName = screenshotName + "_" + timestamp + ".png";
        String destination = System.getProperty("user.dir") + "/screenshots/" + fileName;

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(destination));
            System.out.println("Screenshot saved: " + destination);
        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot: " + e.getMessage());
        }

        return destination;
    }
}
