package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // Mouse hover on “Desktops” Tab and click
        Actions actions = new Actions(driver);
        WebElement Desktops = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(Desktops).click().build().perform();
        //call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");
        //Verify the text ‘Desktops'
        String expectedMessage = "Desktops";
        Assert.assertEquals(expectedMessage, getTextFormElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]")));
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        // Mouse hover on “Laptops & Notebooks” Tab and click
        Actions actions = new Actions(driver);
        WebElement laptopAndNotebooks = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(laptopAndNotebooks).click().build().perform();
        //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");
        //Verify the text ‘Laptops & Notebooks’
        String expectedMessage = "Laptops & Notebooks";
        Assert.assertEquals(expectedMessage, getTextFormElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]")));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //Mouse hover on “Components” Tab and click
        Actions actions = new Actions(driver);
        WebElement Components = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        actions.moveToElement(Components).click().build().perform();
        //call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");
        //Verify the text ‘Components’
        String expectedMessage = "Components";
        Assert.assertEquals(expectedMessage, getTextFormElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]")));

    }

    @After
    public void testDown() {
        closeBrowser();

    }
}
