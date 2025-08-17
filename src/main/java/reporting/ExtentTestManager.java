package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static final ThreadLocal<ExtentTest> tlTest = new ThreadLocal<>();

    public static synchronized ExtentTest startTest(String name, String desc) {
        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest test = extent.createTest(name, desc);
        tlTest.set(test);
        return test;
    }

    public static synchronized ExtentTest getTest() {
        return tlTest.get();
    }

    public static synchronized void endTest() {
        tlTest.remove();
    }
}
