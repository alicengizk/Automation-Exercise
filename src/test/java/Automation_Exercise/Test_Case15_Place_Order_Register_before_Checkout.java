package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case15_Place_Order_Register_before_Checkout extends TestBase {

    /*
    +1. Launch browser
    +2. Navigate to url 'http://automationexercise.com'
    +3. Verify that home page is visible successfully
    +4. Click 'Signup / Login' button
    +5. Fill all details in Signup and create account
    +6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    +7. Verify ' Logged in as username' at top
    +8. Add products to cart
    +9. Click 'Cart' button
    +10. Verify that cart page is displayed
    +11. Click Proceed To Checkout
    +12. Verify Address Details and Review Your Order
    +13. Enter description in comment text area and click 'Place Order'
    +14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    +15. Click 'Pay and Confirm Order' button
    16. Verify success message 'Your order has been placed successfully!'
     */

    @Test
    public void test15() throws InterruptedException {
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        driver.get("http://automationexercise.com");
        WebElement homepage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("ali cengiz");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.id("id_gender1")).click();
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
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        WebElement cartPage=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(cartPage.isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        driver.findElement(By.xpath("//div[@class='checkout-information']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Review Your Order']")).isDisplayed();
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Messasge");
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
