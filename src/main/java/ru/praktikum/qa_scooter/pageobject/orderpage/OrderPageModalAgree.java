package ru.praktikum.qa_scooter.pageobject.orderpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageModalAgree {

    //кнопка согласиться
    private By buttonYes = By.xpath(".//button[text()='Да']");

    public WebDriver driver;

    public OrderPageModalAgree(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPageModalOrderOk clickAgree() {
        driver.findElement(buttonYes).click();
        return new OrderPageModalOrderOk(driver);
    }

}
