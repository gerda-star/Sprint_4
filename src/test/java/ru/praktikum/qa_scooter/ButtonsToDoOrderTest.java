package ru.praktikum.qa_scooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.qa_scooter.pageobject.mainpage.MainPage;


@RunWith(Parameterized.class)
public class ButtonsToDoOrderTest extends BaseTest {

    private final String xpathButton;
    private final String nameButton;

    public ButtonsToDoOrderTest(String xpathButton, String nameButton) {
        this.xpathButton = xpathButton;
        this.nameButton = nameButton;
    }

    @Parameterized.Parameters
    public static Object[][] getButtons() {
        return new Object[][] {
                {".//div[starts-with(@class, 'Header_Nav')]/button[text()='Заказать']", "в шапке"},
                {".//div[starts-with(@class, 'Home_Finish')]/button[text()='Заказать']", "в конце"}
        };
    }

    @Test
    public void doOrder() {
        boolean isOrderOk = new MainPage(driver)
                        .buttonToDoOrderClick(this.xpathButton)
                        .enterDataPerson("имя", "фамилия", "там сям", "81234567890")
                        .clickNext()
                        .enterDataRent("01.07.2023")
                        .clickDoOrder()
                        .clickAgree()
                        .checkIsOrderOk();
        Assert.assertTrue("Заказ не оформлен или нет сообщения об успешном оформлении заказа по кнопке " + this.nameButton, isOrderOk);
    }
}
