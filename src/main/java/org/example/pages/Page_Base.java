package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class Page_Base {
    protected WebDriver driver;

    public Page_Base(WebDriver driver) {

        this.driver = driver;
    }

    public void Enter_text(By elementLocator, String text) {
        driver.findElement(elementLocator).sendKeys(text);
    }

    public void Clk_Button(By elementLocator) {
        driver.findElement(elementLocator).click();
    }

    public void wait(By elementLocator,int sec) {
        new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    public void select_By_index(By elementLocator, int index) {
        Select select = new Select(driver.findElement(elementLocator));
        select.selectByIndex(index);
    }

    public void select_By_value(By elementLocator, String value) {
        Select select = new Select(driver.findElement(elementLocator));
        select.selectByValue(value);
    }

    public void select_By_Visible(By elementLocator, String visible) {
        Select select = new Select(driver.findElement(elementLocator));
        select.selectByVisibleText(visible);
    }
}