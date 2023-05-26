package ru.praktikum.qa_scooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.qa_scooter.pageobject.mainpage.MainPage;


@RunWith(Parameterized.class)
public class ButtonsToDoOrderTest extends BaseTest {

    private final String nameButton;
    private final String name;
    private final String sername;
    private final String address;
    private final String phone;
    private final String date;




    public ButtonsToDoOrderTest(String nameButton, String name, String sername, String address, String phone, String date) {
        this.nameButton = nameButton;
        this.name =name;
        this.sername = sername;
        this.address = address;
        this.phone =phone;
        this.date = date;

    }

    @Parameterized.Parameters
    public static Object[][] getButtons() {
        return new Object[][] {
                {"head", "Иван", "Титов", "Москва Уваровский пр 5", "81234567890", "01.07.2023" },
                {"finish", "Ушаков", "Николай", "Пушкин, ул 9 мая", "893112340011", "24.06.2023"}
        };
    }

    @Test
    public void doOrder() {
        boolean isOrderOk = new MainPage(driver)
                        .buttonToDoOrderClick(this.nameButton)
                        .enterDataPerson(name, sername, address, phone)
                        .clickNext()
                        .enterDataRent(date)
                        .clickDoOrder()
                        .clickAgree()
                        .checkIsOrderOk();
        Assert.assertTrue("Заказ не оформлен или нет сообщения об успешном оформлении заказа по кнопке " + this.nameButton, isOrderOk);
    }
}
