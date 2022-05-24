package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case4_Logout_User extends TestBase {

    /*
    +1. Launch browser
    +2. Navigate to url 'http://automationexercise.com'
    +3. Verify that home page is visible successfully
    +4. Click on 'Signup / Login' button
    +5. Verify 'Login to your account' is visible
    +6. Enter correct email address and password
    +7. Click 'login' button
    +8. Verify that 'Logged in as username' is visible
    +9. Click 'Logout' button
    10. Verify that user is navigated to login page
     */

    @Test
    public void test04() {
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("alicengiz2@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed();
        driver.findElement(By.xpath("//a[@href='/logout']")).click();








    }
}
