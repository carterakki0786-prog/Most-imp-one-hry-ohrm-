package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utilities.ExtentReportManager;
import utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

    private ExtentReports extent = ExtentReportManager.getExtentReports();

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

        extent.flush();

    }

    @Override
    
    public void onTestFailure(ITestResult result) {

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        BaseTest.getDriver(),
                        result.getName());

        test.fail(result.getThrowable());

        test.addScreenCaptureFromPath(screenshotPath);

        
    

        

        extent.flush();

    }

}