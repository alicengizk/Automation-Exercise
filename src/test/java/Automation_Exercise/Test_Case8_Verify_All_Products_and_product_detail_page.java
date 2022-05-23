package Automation_Exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case8_Verify_All_Products_and_product_detail_page extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. The products list is visible
    7. Click on 'View Product' of first product
    8. User is landed to product detail page
    9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
     */

    @Test
    public void test08() {
        Actions actions=new Actions(driver);
        driver.get("http://automationexercise.com");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        driver.findElement(By.xpath("//h2[text()='Blue Top']")).isDisplayed();
        driver.findElement(By.xpath("//p[text()='Category: Women > Tops']")).isDisplayed();
        driver.findElement(By.xpath("//span[text()='Rs. 500']")).isDisplayed();
        driver.findElement(By.xpath("//b[text()='Availability:']")).isDisplayed();
        driver.findElement(By.xpath("//b[text()='Condition:']")).isDisplayed();
        driver.findElement(By.xpath("//b[text()='Brand:']")).isDisplayed();




    }
}
