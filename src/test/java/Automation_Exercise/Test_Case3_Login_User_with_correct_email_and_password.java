package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Test_Case3_Login_User_with_correct_email_and_password extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter incorrect email address and password
    7. Click 'login' button
    8. Verify error 'Your email or password is incorrect!' is visible
     */

    @Test
    public void test03() {
        Faker faker=new Faker();
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(faker.internet().password());
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed();

    }
}
