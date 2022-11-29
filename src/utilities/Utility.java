package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFormElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    //**************************Alert Method ****************************
    //This method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //acceptAlert
    public void acceptAlert() {
        driver.switchTo().alert();
    }

    //dissmissAlert
    public void dismissAlert() {
        driver.switchTo().alert();
    }

    //Get text from Alert
    public void getTextFromAlert() {
        String getTextAlert = driver.switchTo().alert().getText();
    }

    //send text to alert
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);

    }

    // Homework 4 Method (acceptAlert,dismissAlert,  String getTextFromAlert, sendTextToAlert(String text)
    //*********************************  Select Class Methods**********************
    //This method will select option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        //select by value
        select.selectByVisibleText("text");
    }

    //This method will select option by Value
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    //This method will select option by Index
    public void selectByIndexFromDropDown(By by, int text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(text);
    }

    //This method will select option by contains
    public void selectByContainsFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void verifyText(String expectedMessage, By by, String message) {
        WebElement actualTextMessageElement = driver.findElement(by);
        String actualMessage = actualTextMessageElement.getText();
        Assert.assertEquals(message, expectedMessage, actualMessage);
    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(by);
        actions.moveToElement(hover).build().perform();
    }


}


