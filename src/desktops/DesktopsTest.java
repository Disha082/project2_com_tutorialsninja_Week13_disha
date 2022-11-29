package desktops;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));

    }

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);
        WebElement Desktops = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(Desktops).click().build().perform();

        //1.2 Click on “Show All Desktops”
        selectMenu("Show All Desktops");

        //1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver); //
        WebElement Desktops = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(Desktops).click().build().perform();

        //2.2 Click on “Show All Desktops”
        selectMenu("Show All Desktops");

        //2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[3]/div[1]/div[1]/a[1]/img[1]"));

        //2.5 Verify the Text "HP LP3065"
        String expectedMessage = "HP LP3065";
        Assert.assertEquals(expectedMessage, getTextFormElement(By.xpath("//a[contains(text(),'HP LP3065')]")));

        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("//th[@class='picker-switch']")).getText();
            //2011-04-22
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];
            //select expected year
            if (mon.equalsIgnoreCase(month) && yr.equals(year))
                break;
            else
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
        }
        //select date
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
            //2.7.Enter Qty "1” using Select class
            driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
            sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");

            //2.8 Click on “Add to Cart” button
            clickOnElement(By.xpath("//button[@id='button-cart']"));

            //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
            String expectedMessage1 = "Success: You have added HP LP3065 to your shopping cart";
            Assert.assertEquals(expectedMessage1, getTextFormElement(By.xpath("//body/div[@id='product-product']/div[1]]")));

            //2.10 Click on link “shopping cart” display into success message
            clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));

            //2.11 Verify the text "Shopping Cart"
            String expectedMessage2 = "Success: You have added HP LP3065 to your shopping cart";
            Assert.assertEquals(expectedMessage2, getTextFormElement(By.xpath("//span[contains(text(),'Shopping Cart')]")));

            //2.12 Verify the Product name "HP LP3065"
            String expectedMessage3 = "HP LP3065";
            Assert.assertEquals(expectedMessage3, getTextFormElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));

            //2.13 Verify the Delivery Date "2022-11-30
            String expectedMessage4 = "2022-11-30";
            Assert.assertEquals(expectedMessage4, getTextFormElement(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]")));

            //2.14 Verify the Model "Product21"
            String expectedMessage5 = "2022-11-30";
            Assert.assertEquals(expectedMessage5, getTextFormElement(By.xpath("//td[contains(text(),'Product 21')]")));

            //2.15 Verify the Total "£74.73"
            clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
            clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));
            List<WebElement> manageCurrency = driver.findElements(By.xpath("//body/nav[@id='top']/div[1]/div[1]/form[1]/div[1]/ul[1]"));

            for (WebElement element : manageCurrency) {
                if (element.getText().equals("£ Pound Sterling")) {
                    element.click();
                }
            }
            String expectedMessage6 = "£74.73";
            Assert.assertEquals(expectedMessage6, getTextFormElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")));
        }

    }

    @After
    public void testDown() {
        closeBrowser();
    }
}








