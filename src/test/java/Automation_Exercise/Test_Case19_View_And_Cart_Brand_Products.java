package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case19_View_And_Cart_Brand_Products extends TestBase {

    /*
    +1. Launch browser
    +2. Navigate to url 'http://automationexercise.com'
    +3. Click on 'Products' button
    +4. Verify that Brands are visible on left side bar
    +5. Click on any brand name
    +6. Verify that user is navigated to brand page and brand products are displayed
    +7. On left side bar, click on any other brand link
    8. Verify that user is navigated to that brand page and can see products
     */

    @Test
    public void test19() {
        driver.get("http://automationexercise.com");
        WebElement homepage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//div[@class='brands-name']")).isDisplayed();
        driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();
        driver.findElement(By.xpath("//*[text()='Brand - Polo Products']")).isDisplayed();
        driver.findElement(By.xpath("//a[@href='/brand_products/H&M']")).click();
        driver.findElement(By.xpath("//*[text()='Brand - H&M Products']")).isDisplayed();






    }
}
