package seleniumproject.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils {


    public static ExtentTest test;
    public static ExtentReports report;

    public static void takeScreenshot(WebDriver driver, String screenshotName) {

        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./resources/" + screenshotName + ".png"));
        } catch (IOException e) {
            e.getMessage();
        }
    }


    public static void generateExtentReports(String reportName) {
        report = new ExtentReports(System.getProperty("user.dir") + "/test-output/" + reportName + ".html");
        // report.loadConfig(new File(System.getProperty("user.dir")+"\\testng.xml"));
        test = report.startTest(System.getProperty("user.dir") + "\\testng.xml");
        report.flush();


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


}
