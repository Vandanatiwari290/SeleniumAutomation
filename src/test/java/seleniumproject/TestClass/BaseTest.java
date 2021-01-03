package seleniumproject.TestClass;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import seleniumproject.utils.PropertiesFile;
import seleniumproject.utils.TestListener;
import seleniumproject.utils.Utils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)

public class BaseTest{
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static ExtentReports extentReports;
    String browserName;

    @BeforeTest
    public void setDriverPath() {
        extentReports = new ExtentReports(System.getProperty("user.dir") + "/resources/" + "extentReport" + ".html",true);
        extentReports.addSystemInfo("User name", "Vandana");
        extentReports.addSystemInfo("Host name", "Linux");
        extentReports.addSystemInfo("environment", "QA");

        browserName = PropertiesFile.fetchFromPropertyFile().getProperty("chromeBrowserName");
        System.out.println(browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            String driverPath = System.setProperty("webdriver.chrome.driver", "/home/vandanatiwari/Downloads/seleniumJars/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            String driverPath = System.setProperty("webdriver.gecko.driver", "/home/vandanatiwari/Downloads/seleniumJars/geckodriver");
            driver = new FirefoxDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        }
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            extentTest.log(LogStatus.FAIL,result.getName()+"test case has been failed");
            String screenshotPath = Utils.getScreenshot(driver, result.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));

        }
        else if (result.getStatus() == ITestResult.SUCCESS)
        {
            extentTest.log(LogStatus.PASS,result.getName()+"test case has been successfully passed");
        }
        else if (result.getStatus() == ITestResult.SKIP)
        {
            extentTest.log(LogStatus.SKIP,result.getName()+"test case has been skipped");
        }


    }
    /*@AfterMethod
    public void getReports(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(LogStatus.FAIL, "Test case failed is :" + result.getName());
            extentTest.log(LogStatus.FAIL, "Test case failed is :" + result.getThrowable());
            String screenshotPath = Utils.getScreenshot(driver, result.getName());
            //Utils.getScreenshot(driver,result.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP, "Test case skipped is :" + result.getName());
        }
       extentReports.endTest(extentTest);

    }
*/
    /*@AfterMethod
    public void captureScreenShot(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {

            extentTest.log(LogStatus.FAIL, "Test case failed is :" + result.getName());
            extentTest.log(LogStatus.FAIL, "Test case failed is :" + result.getThrowable());
            Utils.getScreenshot(driver, result.getName());
        }

    }*/


    @AfterTest
    public static void afterSuite()
    {
        extentReports.flush();
        //driver.quit();
    }

}

