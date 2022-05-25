package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case25_Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Scroll down page to bottom
    5. Verify 'SUBSCRIPTION' is visible
    6. Click on arrow at bottom right side to move upward
    7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
     */

    @Test
    public void test25() {
        Actions actions=new Actions(driver);
        driver.get("http://automationexercise.com");
        WebElement homepage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());
        actions.sendKeys(Keys.CONTROL,Keys.END).perform();
        driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed();
        driver.findElement(By.id("scrollUp")).click();
        driver.findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']")).isDisplayed();


    }
}
