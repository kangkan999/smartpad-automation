package pages;

import core.DriverFactory;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class LoginPage {
    private WebDriver driver;
    private By continueWithoutAccountLink = By.xpath("//div[normalize-space()='Continue without an account']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void continueWithoutAccount() {
        WebElement link = WaitUtils.waitForElement(driver, continueWithoutAccountLink, 10);
        link.click();
    }

    public void continueWithoutAccountLink() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'continueWithoutAccountLink'");
    }
    
    
}
