package tests;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.CategoryPage;
import pages.LoginPage;
import pages.SearchPage;
import utils.ScreenshotUtils;
import utils.WaitUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class SmartpadFlowTest {

    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void setupExtent() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("SmartpadTestReport.html");
        htmlReporter.config().setDocumentTitle("Smartpad Automation Report");
        htmlReporter.config().setReportName("Smartpad Customer Feedback Flow Tests");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setup(Method method) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        test = extent.createTest(method.getName());
    }

    @Test
    public void testSmartpadFlow() {
        driver.get("https://smartpad-customer-feedback.vercel.app");

        HomePage homePage = new HomePage(driver);
        homePage.clickGetStarted();

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.othersOption();

        LoginPage continuePage = new LoginPage(driver);
        continuePage.continueWithoutAccountLink();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearch("Wine");

        test.pass("Smartpad flow executed successfully!");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
            test.fail("Test Failed: " + result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped: " + result.getThrowable());
        } else {
            test.pass("Test Passed");
        }

        driver.quit();
    }

    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }
}