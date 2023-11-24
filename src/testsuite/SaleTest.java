package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */
public class SaleTest extends BaseTest {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    // calling method from BaseTest class to open and set-up the browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomenJacketsPage() {

        //  Click on ‘Sale’ Menu tab
        driver.findElement(By.xpath("//a[contains(@id,'ui-id-8')]")).click();

        // Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.xpath("//li[@class='item']//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html']")).click();

        //Verify the text ‘Jackets’ is displayed
        String actualDisplayedText = driver.findElement(By.xpath("//h1[contains(@id,'page-title-heading')]")).getText();
        String expectedDisplayedText = "Jackets";

        Assert.assertEquals(expectedDisplayedText, actualDisplayedText);

        // Count the Total Item Displayed on Page
        List<WebElement> items = driver.findElements(By.className("product-item"));
        int itemCount = items.size();
        System.out.println("Total Item Displayed on Page : " + itemCount);

        //  And print the name of all items into console.
        System.out.println("Names of all items on the page: ");
        for (WebElement item : items) {
            System.out.println(item.getText());
        }

        // Verify total 12 Items displayed on page.
        if (itemCount == 12) {
            System.out.println("Test Passed: Total 12 Items displayed on the page.");
        } else {
            System.out.println("Test Failed: Total items displayed on the page are not 12.");
        }


    }

    @After
    public void tearTown() {

        // calling method from BaseTest class to close the browser

        closeBrowser();
    }


}
