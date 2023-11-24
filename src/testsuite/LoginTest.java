package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValid
 * Credentials()
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * 2. verifyTheErrorMessageWithInvalidCredentials
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the error message ‘The account sign-in was
 * incorrect or your account is disabled temporarily. Please wait and try again
 * later.’
 * 3. userShouldLogOutSuccessfully
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */
public class LoginTest extends BaseTest {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    // calling method from BaseTest class to open and set-up the browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        // Enter valid Email
        driver.findElement(By.id("email")).sendKeys("top123-2127253551@gmail.com");

        // Enter valid Password
        driver.findElement(By.id("pass")).sendKeys("Rest@123");

        // Click on ‘Sign In’ button
        driver.findElement(By.id("send2")).click();

        // Verify the ‘Welcome’ text is display
        String expectedText = "Welcome, Top Right!";
        String actualText=driver.findElement(By.xpath("//div[@class='panel wrapper']//span[contains(text(),'Welcome')]")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {

        // Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        // Enter valid Email
        driver.findElement(By.id("email")).sendKeys("top123-2127253551@gmail.com");


        // Enter InValid Password
        driver.findElement(By.id("pass")).sendKeys("Rest@123");

        // Click on ‘Sign In’ button
        driver.findElement(By.id("send2")).click();

        // Verify the error message ‘The account sign-in was incorrect or your account is disabled temporarily.Please wait and try again later.'
        String actualText = driver.findElement(By.xpath("//div[contains(@class,'message-error error message')]")).getText();
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";

        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldLogOutSuccessfully() {

        // Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();


        // Enter valid Email
        driver.findElement(By.id("email")).sendKeys("top123-2127253551@gmail.com");

        //  Enter valid Password
        driver.findElement(By.id("pass")).sendKeys("Rest@123");


        //  Click on ‘Sign In’ button
        driver.findElement(By.id("send2")).click();

        // Verify the ‘Welcome’ text is display
        String expectedText="Welcome, Top Right!";
        String actualText=driver.findElement(By.xpath("//div[@class='panel wrapper']//span[contains(text(),'Welcome')]")).getText();
        Assert.assertEquals(expectedText,actualText);


        // Click on down aero near Welcome
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();


        // Click on Sign Out link
        driver.findElement(By.linkText("Sign Out")).click();

        //  Verify the text ‘You are signed out’
        String actualLogOutMessage = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();

        String expectedLogoutMessage = "You are signed out";
        Assert.assertEquals(expectedLogoutMessage, actualLogOutMessage);


    }


    @After
    public void tearTown() {

        // calling method from BaseTest class to close the browser

        closeBrowser();
    }


}
