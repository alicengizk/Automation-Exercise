package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Test_Case12_Add_Products_in_Cart extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Products' button
    5. Hover over first product and click 'Add to cart'
    6. Click 'Continue Shopping' button
    7. Hover over second product and click 'Add to cart'
    8. Click 'View Cart' button
    9. Verify both products are added to Cart
    10. Verify their prices, quantity and total price
     */

    @Test
    public void test12() throws InterruptedException {
        driver.get("http://automationexercise.com");
        WebElement homepage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        List<WebElement> sutunBasliklariListesi= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Sutun Sayisi : " + sutunBasliklariListesi.size());
        Assert.assertTrue(sutunBasliklariListesi.size()==2);
        driver.findElement(By.xpath("//tbody//tr[1]//td[3]")).isDisplayed();
        driver.findElement(By.xpath("//tbody//tr[2]//td[3]")).isDisplayed();
        driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).isDisplayed();
        driver.findElement(By.xpath("//tbody//tr[2]//td[4]")).isDisplayed();
        driver.findElement(By.xpath("//tbody//tr[1]//td[5]")).isDisplayed();
        driver.findElement(By.xpath("//tbody//tr[2]//td[5]")).isDisplayed();

    }
}
