package seleniumproject.TestClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import seleniumproject.utils.PropertiesFile;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest extends PropertiesFile{
    public WebDriver driver;
    public static ExtentTest test;
    public static ExtentReports report;
    String browserName;
    String browserName2;
  @BeforeTest
    //@Parameters({"browserName","url"})
    public void setDriverPath() {
        browserName= PropertiesFile.fetchFromPropertyFile().getProperty("chromeBrowserName");
        System.out.println(browserName);
        if (browserName.equalsIgnoreCase("chrome")){
            String driverPath = System.setProperty("webdriver.chrome.driver", "/home/vandanatiwari/Downloads/seleniumJars/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
              driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            String driverPath = System.setProperty("webdriver.gecko.driver", "/home/vandanatiwari/Downloads/seleniumJars/geckodriver");
            driver = new FirefoxDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
              driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        }
    }

}
