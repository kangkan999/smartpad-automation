package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class SearchPage {
    private WebDriver driver;
    private By searchBar = By.xpath("//input[@placeholder='Search']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String query) {
        WebElement searchInput = WaitUtils.waitForElement(driver, searchBar, 10);
        searchInput.sendKeys("Wine");
        searchInput.submit();
    }

    public void enterSearch(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterSearch'");
    }

    
}
