package Automation_Exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case22_Add_to_cart_from_Recommended_items extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Scroll to bottom of page
    4. Verify 'RECOMMENDED ITEMS' are visible
    5. Click on 'Add To Cart' on Recommended product
    6. Click on 'View Cart' button
    7. Verify that product is displayed in cart page
     */

    @Test
    public void test22() throws InterruptedException {
        Actions actions=new Actions(driver);
        driver.get("http://automationexercise.com");
        actions.sendKeys(Keys.CONTROL,Keys.END).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//*[text()='recommended items']")).isDisplayed();
        driver.findElement(By.xpath("//div[@id='recommended-item-carousel']//a[@data-product-id='1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).isDisplayed();


    }
}
