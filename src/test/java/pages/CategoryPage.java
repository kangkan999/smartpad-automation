package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class CategoryPage {
    private WebDriver driver;
    private By othersOption = By.xpath("//div[contains(text(),'Others')]");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOthers() {
        WebElement option = WaitUtils.waitForElement(driver, othersOption, 10);
        option.click();
    }

    public void othersOption() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'othersOption'");
    }
    
}
