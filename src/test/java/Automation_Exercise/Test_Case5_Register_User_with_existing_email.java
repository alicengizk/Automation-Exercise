package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case5_Register_User_with_existing_email extends TestBase {

    /*
    +1. Launch browser
    +2. Navigate to url 'http://automationexercise.com'
    +3. Verify that home page is visible successfully
    +4. Click on 'Signup / Login' button
    +5. Verify 'New User Signup!' is visible
    +6. Enter name and already registered email address
    +7. Click 'Signup' button
    +8. Verify error 'Email Address already exist!' is visible
     */

    @Test
    public void test05() {
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("ali cengiz");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("alicengiz2@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed();







    }
}
