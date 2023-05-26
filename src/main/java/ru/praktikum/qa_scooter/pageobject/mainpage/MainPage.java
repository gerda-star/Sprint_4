package ru.praktikum.qa_scooter.pageobject.mainpage;

import org.junit.Assert;
import org.openqa.selenium.*;
import ru.praktikum.qa_scooter.pageobject.orderpage.OrderPageFormPerson;


import static ru.praktikum.qa_scooter.config.AppConfig.APP_URL;

public class MainPage {
    //Кнопка заказа 1
    private By buttonOrderInHeader = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[text()='Заказать']");
    //Кнопка заказа 2
    private By buttonOrderInFinish = By.xpath(".//div[starts-with(@class, 'Home_Finish')]/button[text()='Заказать']");
    private By buttonLocator;

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(APP_URL);


    }
    public OrderPageFormPerson buttonToDoOrderClick(String nameButton) {
        if (nameButton.equals("head")) {
            buttonLocator = buttonOrderInHeader;
        } else {
            buttonLocator = buttonOrderInFinish;
        }
        WebElement buttonToDo = driver.findElement(buttonLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", buttonToDo);
        buttonToDo.click();
        return new OrderPageFormPerson(driver);
    }

    public DivFAQ goToFAQ() {
        return new DivFAQ(driver);
    }


}
