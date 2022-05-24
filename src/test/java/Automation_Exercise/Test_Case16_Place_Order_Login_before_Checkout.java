package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case16_Place_Order_Login_before_Checkout extends TestBase {

    /*

    +1. Launch browser
    +2. Navigate to url 'http://automationexercise.com'
    +3. Verify that home page is visible successfully
    +4. Click 'Signup / Login' button
    +5. Fill email, password and click 'Login' button
    +6. Verify 'Logged in as username' at top
    +7. Add products to cart
    +8. Click 'Cart' button
    +9. Verify that cart page is displayed
    +10. Click Proceed To Checkout
    +11. Verify Address Details and Review Your Order
    +12. Enter description in comment text area and click 'Place Order'
    +13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    +14. Click 'Pay and Confirm Order' button
    +15. Verify success message 'Your order has been placed successfully!'
     */

    @Test
    public void test16() throws InterruptedException {
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        driver.get("http://automationexercise.com");
        WebElement homepage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("alicengiz2@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        String expectedUsername="ali cengiz";
        String actualUserName=driver.findElement(By.xpath("//b[text()]")).getText();
        Assert.assertEquals(expectedUsername,actualUserName);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        WebElement cartPage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(cartPage.isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        driver.findElement(By.xpath("//div[@class='checkout-information']")).isDisplayed();
        driver.findElement(By.id("cart_info")).isDisplayed();
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("mesaj");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("ali cengiz");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys(faker.business().creditCardNumber());
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("06");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("1982");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed();

    }
}
