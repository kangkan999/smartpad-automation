package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class HomePage {
    private WebDriver driver;
    private By getStartedButton = By.xpath("//button[contains(text(),'Get started')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickGetStarted() {
        WebElement button = WaitUtils.waitForElement(driver, getStartedButton, 10);
        button.click();
    }
    
}
