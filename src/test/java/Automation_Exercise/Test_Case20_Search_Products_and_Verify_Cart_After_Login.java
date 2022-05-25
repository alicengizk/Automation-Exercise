package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case20_Search_Products_and_Verify_Cart_After_Login extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Click on 'Products' button
    4. Verify user is navigated to ALL PRODUCTS page successfully
    5. Enter product name in search input and click search button
    6. Verify 'SEARCHED PRODUCTS' is visible
    7. Verify all the products related to search are visible
    8. Add those products to cart
    9. Click 'Cart' button and verify that products are visible in cart
    10. Click 'Signup / Login' button and submit login details
    11. Again, go to Cart page
    12. Verify that those products are visible in cart after login as well
     */

    @Test
    public void test20() throws InterruptedException {
        Actions actions=new Actions(driver);
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed();
        driver.findElement(By.id("search_product")).sendKeys("Blue Top");
        driver.findElement(By.id("submit_search")).click();
        String actualProductName=driver.findElement(By.xpath("//*[text()='Blue Top'][1]")).getText();
        String expectedProductName="Blue Top";
        Assert.assertEquals(expectedProductName,actualProductName);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        String actualCartProduct=driver.findElement(By.xpath("//a[@href='/product_details/1']")).getText();
        String expectedCartProduct="Blue Top";
        Assert.assertEquals(expectedCartProduct,actualCartProduct);
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("alicengiz2@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        String actualCartProduct2=driver.findElement(By.xpath("//a[@href='/product_details/1']")).getText();
        String expectedCartProduct2="Blue Top";
        Assert.assertEquals(expectedCartProduct2,actualCartProduct2);





    }
}
