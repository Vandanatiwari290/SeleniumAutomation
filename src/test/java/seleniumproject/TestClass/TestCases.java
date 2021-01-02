/*
package seleniumproject.TestClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import seleniumproject.utils.TestListener;
import seleniumproject.utils.Utils;
import java.io.File;
import java.io.IOException;

@Listeners( TestListener.class)

public class TestCases extends BaseTest {
    public static ExtentTest logger;
    public static ExtentReports report;
    public WebDriver driver;
    @Test(priority = 0)
    public void getTitleOfPage() throws IOException {
        Assert.assertEquals(driver.getTitle(), "Google");
    }


    @Test(priority = 1)
    public void searchForCricket() {
        logger = report.startTest("passTest");
        driver.findElement(By.name("q")).sendKeys("faceebook.com");
    }

   */
/* @Test
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
         WebElement Element= driver.findElement(By.className("udlite-focus-visible-target udlite-heading-md course-card--course-title--2f7tE"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    @Test
    public void mouseHover(){
        WebElement ele = driver.findElement(By.cssSelector("div[class='2020 Complete Python Bootcamp From Zero to Hero in Python']"));
         //Create object 'action' of an Actions class
        Actions action = new Actions(driver);
         //Mouseover on an element
        action.moveToElement(ele).perform();
    }*//*




    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Utils.takeScreenshot(driver, result.getName());
        }
    }
    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }

        report.endTest(logger);
    }


    @BeforeTest
    public void generateExtentReports(){
        report=new ExtentReports(System.getProperty("user.dir")+"/test-output/extentReports.html",true);
        report
                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Vandana");
        report.loadConfig(new File(System.getProperty("user.dir")+"\\testng.xml"));
        report.flush();

    }
    @AfterTest
    public void endReport(){
        report.flush();
        report.close();
    }


}





*/
