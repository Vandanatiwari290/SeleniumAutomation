/*
package seleniumproject.TestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumproject.utils.RetryAnalyser;
import seleniumproject.utils.Utils;
import java.util.List;
public class googleSearchTest extends BaseTest {

    //@Test(retryAnalyzer =RetryAnalyser.class,priority = 1)
    @Test(priority = 1)
    public void testcase1() {
        extentTest= extentReports.startTest("Google Test", "Test to launch google site");
         System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("testing");
        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));
        System.out.println("Total number of suggestion is:" + list.size());
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            System.out.println(text);
        }
    }
    @Test(priority = 2)
    public static void scrollThePage(){
        Utils.scrollPageDown(driver);
    }

    @Test(priority = 3)
    public void matchThePageTitle(){
        Assert.assertEquals(driver.getTitle(),"hhh");
    }


}


*/
