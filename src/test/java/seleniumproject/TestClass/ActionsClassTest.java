package seleniumproject.TestClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClassTest extends BaseTest {
    @Test
    public void mouseHover() throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-5760-particle\"]/nav/ul/li[2]/div/span[1]"))).build().perform();
    }
}
