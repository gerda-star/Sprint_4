package ru.praktikum.qa_scooter.pageobject.mainpage;

import org.junit.Assert;
import org.openqa.selenium.*;
import ru.praktikum.qa_scooter.pageobject.orderpage.OrderPageFormPerson;


import static ru.praktikum.qa_scooter.config.AppConfig.APP_URL;

public class MainPage {
    //Кнопка заказа
    private By buttonOrderInHeader = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[text()='Заказать']");



    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(APP_URL);


    }
    public OrderPageFormPerson buttonToDoOrderClick(String xpathButton) {
            WebElement buttonToDo = driver.findElement(By.xpath(xpathButton));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", buttonToDo);
            buttonToDo.click();
            return new OrderPageFormPerson(driver);
    }

    public DivFAQ goToFAQ() {
        return new DivFAQ(driver);
    }


}
