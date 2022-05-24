package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case7_Verify_Test_Cases_Page extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Test Cases' button
    5. Verify user is navigated to test cases page successfully
     */

    @Test
    public void test07() {
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/test_cases']")).click();
        System.out.println("Test Page URL : "+driver.getCurrentUrl());
        WebElement testPage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(testPage.isDisplayed());
        WebElement testCase = driver.findElement(By.xpath("//b[normalize-space()='Test Cases']"));
        Assert.assertTrue(testCase.isDisplayed());



    }
}
