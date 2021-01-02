package seleniumproject.TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
public class googleSearchTest extends BaseTest{
    @Test
    public void testcase1(){

        System.out.println(driver.getTitle());
     /*driver.findElement(By.name("q")).sendKeys("testing");
      List<WebElement>list=  driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));
        System.out.println("Total number of suggestion is:"+list.size());
        for (int i=0;i<list.size();i++){
            String text=list.get(i).getText();
            System.out.println(text);*/
        }
    }


