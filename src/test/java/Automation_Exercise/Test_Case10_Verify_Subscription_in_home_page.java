package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

public class Test_Case10_Verify_Subscription_in_home_page extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Scroll down to footer
    5. Verify text 'SUBSCRIPTION'
    6. Enter email address in input and click arrow button
    7. Verify success message 'You have been successfully subscribed!' is visible
     */

    @Test
    public void test10() {
        Faker faker=new Faker();
        driver.get("http://automationexercise.com");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
        driver.findElement(By.id("susbscribe_email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("subscribe")).click();
        driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed();



    }
}
