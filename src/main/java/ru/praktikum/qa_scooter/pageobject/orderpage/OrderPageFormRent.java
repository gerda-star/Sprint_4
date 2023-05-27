package ru.praktikum.qa_scooter.pageobject.orderpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageFormRent {


    // Когда привезти
    private By fieldDate = By.xpath("//input[starts-with(@placeholder, '* Когда привезти самокат')]");
    //список для аренды
    private By arrowlistOfPeriod = By.xpath(".//div[@aria-haspopup='listbox']");
    // елемент списка период
    private By periodValue = By.xpath(".//div[text()='двое суток']");
    // день в каллендаре
    private By buttonValueDay = By.xpath(".//div[starts-with(@class,'react-datepicker') and @role='button' and @tabindex='0']");
    // чекбокс цвет
    private By checkboxColor = By.xpath(".//input[@type='checkbox' and @id='black']");
    // кнопка заказать
    private By buttonDoOrder = By.xpath(".//div[starts-with(@class,'Order')]//button[text()='Заказать']");



    public WebDriver driver;

    public OrderPageFormRent(WebDriver driver) {
        this.driver = driver;
    }


    public OrderPageFormRent fillDate(String date) {
        driver.findElement(fieldDate).sendKeys(date);
        driver.findElement(buttonValueDay).click();
        return this;
    }
    public OrderPageFormRent selectPeriod() {
        driver.findElement(arrowlistOfPeriod).click();
        driver.findElement(periodValue).click();
        return this;
    }

    public OrderPageFormRent selectColor() {
        driver.findElement(checkboxColor).click();
        return this;
    }

    public OrderPageModalAgree clickDoOrder() {
        driver.findElement(buttonDoOrder).click();
        return new OrderPageModalAgree(driver);
    }

    public OrderPageFormRent enterDataRent(String date) {
        this.fillDate(date)
                .selectPeriod()
                .selectColor();
        return this;
    }


}
