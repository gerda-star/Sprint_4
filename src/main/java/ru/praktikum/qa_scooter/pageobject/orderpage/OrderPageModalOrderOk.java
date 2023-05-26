package ru.praktikum.qa_scooter.pageobject.orderpage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import java.util.regex.Pattern;

public class OrderPageModalOrderOk {

    //кнопка согласиться
    private By messageOrderOk = By.xpath(".//div[starts-with(text(), 'Заказ оформлен')]");

    public WebDriver driver;

    public OrderPageModalOrderOk(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkIsOrderOk() {
        try {
            return driver.findElement(messageOrderOk).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void getNumberOrder() {
    }



}
