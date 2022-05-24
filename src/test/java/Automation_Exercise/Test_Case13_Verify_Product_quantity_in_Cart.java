package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case13_Verify_Product_quantity_in_Cart extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'View Product' for any product on home page
    5. Verify product detail is opened
    6. Increase quantity to 4
    7. Click 'Add to cart' button
    8. Click 'View Cart' button
    9. Verify that product is displayed in cart page with exact quantity
     */

    @Test
    public void test13() throws InterruptedException {
        driver.get("http://automationexercise.com");
        WebElement homepage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        WebElement productDetails=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(productDetails.isDisplayed());
        driver.findElement(By.xpath("//input[@id='quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("4");
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        String eklenenUrunAdedi=driver.findElement(By.xpath("//tbody//td[4]")).getText();
        String istenenUrunAdedi="4";
        Assert.assertEquals(istenenUrunAdedi,eklenenUrunAdedi);




    }
}
