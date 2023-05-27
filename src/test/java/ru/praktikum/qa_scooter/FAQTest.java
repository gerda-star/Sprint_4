package ru.praktikum.qa_scooter;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.qa_scooter.pageobject.mainpage.MainPage;

import static ru.praktikum.qa_scooter.DataFAQ.dataFAQ;

/* этот тест плохо ведет себя в файер фоксе. Не успела разобраться почему.
Пробовала решить с явным ожиданием - пока не вышло.  */
@RunWith(Parameterized.class)
public class FAQTest extends BaseTest {

    private final String question;
    private  final String answer;

    public FAQTest(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestAndAns() {
        return dataFAQ;
        }

    @Test
    public void checkAnswerAfterClickQuestion() {
        new MainPage(driver)
                .goToFAQ()
                .checkAnswerAfterClick(question, answer);

    }


}
