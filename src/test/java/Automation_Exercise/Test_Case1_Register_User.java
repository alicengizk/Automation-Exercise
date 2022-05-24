package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case1_Register_User  extends TestBase {
    
    /*
    +1. Launch browser
    +2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    +4. Click on 'Signup / Login' button
    +5. Verify 'New User Signup!' is visible
    +6. Enter name and email address
    +7. Click 'Signup' button
    +8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    +9. Fill details: Title, Name, Email, Password, Date of birth
    +10. Select checkbox 'Sign up for our newsletter!'
    +11. Select checkbox 'Receive special offers from our partners!'
    +12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    +13. Click 'Create Account button'
    +14. Verify that 'ACCOUNT CREATED!' is visible
    +15. Click 'Continue' button
    +16. Verify that 'Logged in as username' is visible
    +17. Click 'Delete Account' button
    +18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    @Test
    public void test01() {
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.xpath("//h2[@class='title text-center'][1]")).isDisplayed();
        driver.findElement(By.id("id_gender1")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(faker.internet().password());
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
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();
        driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed();
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();

























    }
}
