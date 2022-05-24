package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case17_Remove_Products_From_Cart extends TestBase {

    /*
    +1. Launch browser
    +2. Navigate to url 'http://automationexercise.com'
    +3. Verify that home page is visible successfully
    +4. Add products to cart
    +5. Click 'Cart' button
    +6. Verify that cart page is displayed
    +7. Click 'X' button corresponding to particular product
    +8. Verify that product is removed from the cart
     */

    @Test
    public void test17() throws InterruptedException {
        Actions actions=new Actions(driver);
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart'][1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        WebElement cartPage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(cartPage.isDisplayed());
        driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();
        driver.findElement(By.xpath("//*[text()='Cart is empty!']")).isDisplayed();





    }
}
