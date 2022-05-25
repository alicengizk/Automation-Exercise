package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case24_Download_Invoice_after_purchase_order extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Add products to cart
    5. Click 'Cart' button
    6. Verify that cart page is displayed
    7. Click Proceed To Checkout
    8. Click 'Register / Login' button
    9. Fill all details in Signup and create account
    10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    11. Verify ' Logged in as username' at top
    12.Click 'Cart' button
    13. Click 'Proceed To Checkout' button
    14. Verify Address Details and Review Your Order
    15. Enter description in comment text area and click 'Place Order'
    16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    17. Click 'Pay and Confirm Order' button
    18. Verify success message 'Your order has been placed successfully!'
    19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
    20. Click 'Continue' button
     */

    @Test
    public void test24() throws InterruptedException {
        driver.get("http://automationexercise.com");
        WebElement homepage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Add to cart'][1]")).click();
        driver.findElement(By.xpath("//*[text()='Your product has been added to cart.']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("ali cengiz");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.id("id_gender1")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("3");
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("June");
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1982");
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(faker.address().buildingNumber());
        driver.findElement(By.xpath("//select[@id='country']")).sendKeys("United States");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();
        driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed();
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        String expectedUsername="ali cengiz";
        String actualUserName=driver.findElement(By.xpath("//b[text()]")).getText();
        Assert.assertEquals(expectedUsername,actualUserName);
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
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
        driver.findElement(By.xpath("//a[@href='/download_invoice/500']")).click();
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


    }
}
