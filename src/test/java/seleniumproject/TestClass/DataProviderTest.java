package seleniumproject.TestClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderTest {
    WebDriver driver;
    @BeforeTest
    public void setDriverPath() {
            WebDriverManager.chromedriver().setup();
            //String driverPath = System.setProperty("webdriver.chrome.driver", "/home/vandanatiwari/Downloads/seleniumJars/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.facebook.com/");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        }

        @Test(dataProvider = "data-provider")
    public void login(String userNmae,String pass){
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(userNmae);
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(pass);
        }


        @DataProvider (name = "data-provider")
        public Object[][] dpMethod(){
            return new Object[][] {{"vandut12055@gmail.com"}, {"password"}};
        }
}
