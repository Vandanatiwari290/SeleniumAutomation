package seleniumproject.TestClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        extentTest = extentReports.startTest("Test Name","Description");


        browserName = PropertiesFile.fetchFromPropertyFile().getProperty("chromeBrowserName");
        System.out.println(browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            //String driverPath = System.setProperty("webdriver.chrome.driver", "/home/vandanatiwari/Downloads/seleniumJars/chromedriver");
            driver = new ChromeDriver();
            //driver.get("https://www.google.com/");
            driver.get("https://www.guru99.com/selenium-tutorial.html");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
           // String driverPath = System.setProperty("webdriver.gecko.driver", "/home/vandanatiwari/Downloads/seleniumJars/geckodriver");
            driver = new FirefoxDriver();
            driver.get("https://www.guru99.com/selenium-tutorial.html");
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
            //extentTest.log(LogStatus.FAIL, String.valueOf(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()));
           extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

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

    @AfterTest
    public static void afterSuite()
    {
        extentReports.flush();
        //driver.quit();
    }

}

