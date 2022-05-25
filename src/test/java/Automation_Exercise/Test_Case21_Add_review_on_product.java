package Automation_Exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case21_Add_review_on_product extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Click on 'Products' button
    4. Verify user is navigated to ALL PRODUCTS page successfully
    5. Click on 'View Product' button
    6. Verify 'Write Your Review' is visible
    7. Enter name, email and review
    8. Click 'Submit' button
    9. Verify success message 'Thank you for your review.'
     */

    @Test
    public void test21() {
        Actions actions=new Actions(driver);
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed();
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        driver.findElement(By.xpath("//a[@href='#reviews']")).isDisplayed();
        driver.findElement(By.id("name")).sendKeys("ali cengiz");
        driver.findElement(By.id("email")).sendKeys("alicengiz@gmail.com");
        driver.findElement(By.id("review")).sendKeys("inceleme");
        driver.findElement(By.id("button-review")).click();
        driver.findElement(By.xpath("//*[text()='Thank you for your review.']")).isDisplayed();

    }
}
