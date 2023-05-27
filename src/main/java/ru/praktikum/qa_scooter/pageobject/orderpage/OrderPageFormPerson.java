package ru.praktikum.qa_scooter.pageobject.orderpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.qa_scooter.pageobject.mainpage.MainPage;

public class OrderPageFormPerson {

    // Поле имя
    private By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле фамилия
    private By fieldSername = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле адрес
    private By fieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле метро
    private By divMetro = By.xpath(".//input[@class='select-search__input']");
    // елемент спсика метро
    private By MetroValue = By.xpath(".//div[@class='select-search__select']//button[@value='1']");
    // Поле телефон
    private By fieldPhone = By.xpath("//input[starts-with(@placeholder, '* Телефон')]");
    //кнпока далее
    private By buttonNextStep = By.xpath(".//button[text()='Далее']");
    //кнопка согласиться на куки
    private By buttonCookie = By.id("rcc-confirm-button");


    public WebDriver driver;

    public OrderPageFormPerson(WebDriver driver) {
        this.driver = driver;
        this.clickYesOnCookie();
    }


    public OrderPageFormPerson fillName(String name) {
        driver.findElement(fieldName).sendKeys(name);
        return this;
    }

    public OrderPageFormPerson fillSername(String sername) {
        driver.findElement(fieldSername).sendKeys(sername);
        return this;
    }

    public OrderPageFormPerson fillAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
        return this;
    }

    public OrderPageFormPerson fillPhone(String Phone) {
        driver.findElement(fieldPhone).sendKeys(Phone);
        return this;
    }

    public OrderPageFormPerson selectMetro() {
        driver.findElement(divMetro).click();
        driver.findElement(MetroValue).click();
        return this;
    }
    public OrderPageFormRent clickNext() {
        driver.findElement(buttonNextStep).click();
        return new OrderPageFormRent(driver);
    }

    public OrderPageFormPerson enterDataPerson(String name, String sername, String address, String phone) {
        this.fillName(name)
                .fillSername(sername)
                .fillAddress(address)
                .selectMetro()
                .fillPhone(phone);
        return this;
    }

    public OrderPageFormPerson clickYesOnCookie() {
        driver.findElement(buttonCookie).click();
        return this;
    }

}
