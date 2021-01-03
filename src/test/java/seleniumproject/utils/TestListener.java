package seleniumproject.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import seleniumproject.TestClass.BaseTest;

import java.io.IOException;

import static seleniumproject.utils.Utils.getScreenshot;

public class TestListener implements ITestListener {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static ExtentReports extentReports;
    @Override
    public void onFinish(ITestContext Result)
    {

    }

    @Override
    public void onStart(ITestContext result)
    {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
    {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult Result) {

        System.out.println("Test case skipped :"+Result.getName());
    }

    @Override
    public void onTestStart(ITestResult Result)
    {

        System.out.println(Result.getName()+" test case started");
    }


    @Override
    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("The name of the testcase passed is :"+Result.getName());
    }
}

