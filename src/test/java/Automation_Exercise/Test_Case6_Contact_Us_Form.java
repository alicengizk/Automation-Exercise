package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case6_Contact_Us_Form extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void test06() {
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
       driver.get("http://automationexercise.com");
       String homeUrl= driver.getCurrentUrl();
       driver.getCurrentUrl().isBlank();
       driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
       driver.findElement(By.xpath("//*[text()='Get In Touch']")).isDisplayed();
       driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys(faker.name().firstName());
       driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys(faker.internet().emailAddress());
       driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("Baslik");
       driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Biseyler");
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       driver.findElement(By.xpath("//input[@name='upload_file']")).submit();
       driver.switchTo().alert().accept();
       driver.findElement(By.xpath("//*[text()='Success! Your details have been submitted successfully.']")).isDisplayed();
       driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
       String sonUrl=driver.getCurrentUrl();
       Assert.assertEquals(sonUrl,homeUrl);


    }
}
