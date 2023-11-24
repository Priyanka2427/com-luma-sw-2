package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

/**
 *
 */
public class RegisterTest extends BaseTest {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    // calling method from BaseTest class to open and set-up the browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        //  click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//header[@class='page-header']//a[text()='Create an Account']")).click();

        //  Verify the text ‘Create New Customer Account’
        String actualTest = driver.findElement(By.xpath("//span[text()='Create New Customer Account']")).getText();
        String expectedText = "Create New Customer Account";

        Assert.assertEquals("Text is not matched", expectedText, actualTest);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //  click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//header[@class='page-header']//a[text()='Create an Account']")).click();

        // Enter First name
        driver.findElement(By.id("firstname")).sendKeys("Top");

        // Enter Last name
        driver.findElement(By.name("lastname")).sendKeys("Right");

        // Click on checkbox Sign Up for Newsletter


        // Enter Email
        Random random = new Random();
        String randomEmail = "top123" + random.nextInt() + "@gmail.com";
        driver.findElement(By.name("email")).sendKeys(randomEmail);

        // Enter Password
        driver.findElement(By.name("password")).sendKeys("Rest@123");

        //Enter Confirm Password
        driver.findElement(By.name("password_confirmation")).sendKeys("Rest@123");

        // Click on Create an Account button
        driver.findElement(By.xpath("//button[@type='submit' and@class='action submit primary']")).click();

        // Verify the text 'Thank you for registering with Main Website Store.'
        String actualRegistrationText = driver.findElement(By.xpath("//div[text() = 'Thank you for registering with Main Website Store.']")).getText();
        String expectedRegistrationText = "Thank you for registering with Main Website Store.";

        Assert.assertEquals(expectedRegistrationText, actualRegistrationText);

        // Click on down aero near Welcome
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();

        // Click on Sign Out link
      //  driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]")).click();

        driver.findElement(By.linkText("Sign Out")).click();

        // Verify the text ‘You are signed out’
        String actualLogOutMessage =  driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();

        String expectedLogoutMessage = "You are signed out";
        Assert.assertEquals(expectedLogoutMessage, actualLogOutMessage);


    }

    @After
 public void tearTown() {

    // calling method from BaseTest class to close the browser

       closeBrowser();
    }

}








