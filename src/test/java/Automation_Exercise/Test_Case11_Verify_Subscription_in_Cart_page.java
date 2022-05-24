package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case11_Verify_Subscription_in_Cart_page extends TestBase {

    /*
    +1. Launch browser
    +2. Navigate to url 'http://automationexercise.com'
    +3. Verify that home page is visible successfully
    4. Click 'Cart' button
    5. Scroll down to footer
    6. Verify text 'SUBSCRIPTION'
    7. Enter email address in input and click arrow button
    8. Verify success message 'You have been successfully subscribed!' is visible
     */

    @Test
    public void test11() {
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        driver.get("http://automationexercise.com");
        WebElement homepage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/view_cart'][1]")).click();
        actions.sendKeys(Keys.CONTROL,Keys.END);
        driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
        driver.findElement(By.id("susbscribe_email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("subscribe")).click();
        String expectedMessage="You have been successfully subscribed!";
        String actualMessage=driver.findElement(By.id("success-subscribe")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);






    }
}
