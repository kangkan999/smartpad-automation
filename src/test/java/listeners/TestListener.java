package listeners;

import com.aventstack.extentreports.Status;
import core.DriverFactory;
import org.testng.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener, ISuiteListener {

     @Override
    public void onStart(ISuite suite) {
        ExtentManager.getInstance(); // init
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String name = result.getMethod().getMethodName();
        ExtentTestManager.startTest(name, result.getMethod().getDescription());
        ExtentTestManager.getTest().log(Status.INFO, "Starting test: " + name);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test passed");
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtil.takeScreenshot(result.getMethod().getMethodName());
        ExtentTestManager.getTest().fail(result.getThrowable());
        if (screenshotPath != null) {
            try {
                ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception ignored) {}
        }
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test skipped: " + result.getSkipCausedBy().toString());
        ExtentTestManager.endTest();
    }

    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}

    
}
