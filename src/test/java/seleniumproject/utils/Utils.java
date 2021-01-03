package seleniumproject.utils;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
        String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
       String destination=System.getProperty("user.dir")+"/resources/" +screenshotName + dateName +".png";
        FileUtils.copyFile(src, new File(destination));
        return screenshotName;
    }


    public static void setExtentReportsPath(String reportName) {
        extentReports = new ExtentReports(System.getProperty("user.dir") + "/resources/" + reportName + ".html",true);
        extentReports.addSystemInfo("User name", "Vandana");
        extentReports.addSystemInfo("Host name", "Linux");
        extentReports.addSystemInfo("environment", "QA");
        extentTest = extentReports.startTest("Test Name","Description");
        extentReports.flush();



       /* extentReports.endTest(extentTest);
        extentTest.log(LogStatus.PASS,"Test Passed");
        extentTest.log(LogStatus.FAIL,"Test Failed");
        extentTest.log(LogStatus.SKIP,"Test Skipped");
        extentTest.log(LogStatus.INFO,"Test Info");*/

    }

    public void sendMail() throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("username", "password"));
        email.setSSLOnConnect(true);
        email.setFrom("vandhana.tiwari@gonuclei.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("foo@bar.com");
        email.send();
    }

    public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor(element, driver, "rgb(0,200,0)");
            changeColor(element, driver, bgColor);
        }

    }

    private static void changeColor(WebElement element, WebDriver driver, String color) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {

        }
    }

    private static void drawBoarder(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);

    }

    private static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + message + "')");

    }

    public static void clickElementByJs(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    public static void refreshBrowserByJs(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");

    }

    public static String getTitleByJs(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title;").toString();
        return title;

    }

    public static String getPageInnerTextByJs(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;

    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }


}
