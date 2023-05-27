package ru.praktikum.qa_scooter.pageobject.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class DivFAQ extends MainPage{

    // кнопка для вопросов в блоке FAQ
    private By buttonInFAQ = By.className("accordion__button");
    // текст видимого ответа
    private By answerVisible = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]/p");

    WebElement[] questionButtons;
    String ansText;
    String questText;

    public DivFAQ(WebDriver driver) {
        super(driver);
        findQuestionButtons();
    }

    // найти все кнопки вопросов
    public void findQuestionButtons() {
        questionButtons = driver.findElements(buttonInFAQ).toArray(new WebElement[0]);

    }
    // клик по кнопке вопроса
    public DivFAQ clickQuestion(WebElement questionButton) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionButton);
        questionButton.click();
        return this;
    }
    // найти текст вопроса
    public String readQuestion(WebElement questionButton) {
        questText = questionButton.getText();
        return questText;
    }
    // найти текст видимого ответа
    public String readAnswer() {
        return driver.findElement(answerVisible).getText();
    }
    //проверить ответ на вопрос
    public void checkAnswerAfterClick(String question, String answer) {
        for (WebElement questionButton : questionButtons) {
            readQuestion(questionButton);
            if (questText.equals(question)) {
                ansText = this.clickQuestion(questionButton)
                        .readAnswer();
                assertEquals("Не сошлась пара 'ответ-впорос'",answer, ansText);
                break;
                    }

        };

    }


}


