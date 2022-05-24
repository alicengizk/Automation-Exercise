package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.sql.Driver;

public class Test_Case18_View_Category_Products extends TestBase {

    /*
    +1. Launch browser
    +2. Navigate to url 'http://automationexercise.com'
    +3. Verify that categories are visible on left side bar
    +4. Click on 'Women' category
    +5. Click on any category link under 'Women' category, for example: Dress
    +6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
    +7. On left side bar, click on any sub-category link of 'Men' category
    8. Verify that user is navigated to that category page
     */

    @Test
    public void test18() {
        Actions actions = new Actions(driver);
        driver.get("http://automationexercise.com");
        actions.sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.xpath("//div[@class='left-sidebar']")).isDisplayed();
        driver.findElement(By.xpath("//a[@href='#Women']")).click();
        driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();
        String dressCategory=driver.findElement(By.xpath("//li[@class='active']")).getText();
        String category="Women > Dress";
        Assert.assertTrue(dressCategory.contains(category));
        String womenProduct=driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        String expectedProduct="WOMEN - TOPS PRODUCTS";
        Assert.assertFalse(womenProduct==expectedProduct);
        driver.findElement(By.xpath("//a[@href='#Men']")).click();
        driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();
        String menCategory=driver.findElement(By.xpath("//li[@class='active']")).getText();
        String expectedMen="Men > Tshirts";
        Assert.assertTrue(menCategory.contains(expectedMen));






    }
}
