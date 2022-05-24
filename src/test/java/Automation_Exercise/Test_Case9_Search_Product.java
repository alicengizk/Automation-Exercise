package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Test_Case9_Search_Product extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. Enter product name in search input and click search button
    7. Verify 'SEARCHED PRODUCTS' is visible
    8. Verify all the products related to search are visible
     */

    @Test
    public void test09() {

        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed();
        String aranacakKelime="Dress";
        driver.findElement(By.id("search_product")).sendKeys(aranacakKelime);
        driver.findElement(By.id("submit_search")).click();
        driver.findElement(By.xpath("//*[text()='Searched Products']")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='productinfo text-center']/p")).isDisplayed();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        for (WebElement each:products
             ) {
            Assert.assertTrue(each.isDisplayed());

        }








    }
}
