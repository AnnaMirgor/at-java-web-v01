package work.myAviasalesPOM;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BuyPage {

    SelenideElement
            addBaggageFirst = $x("//div[@id='passengers-1']//button//span[text()='Добавить']"),
            addBaggageSecond = $x("//div[@id='passengers-2']//button//span[text()='Добавить']"),
            nextStepButton = $x("//aside//button[@data-test-id='next-step-button']");

    @Step("Добавить багаж 2-му пассажиру")
    public void addBaggageSecond() {
        this.addBaggageSecond.shouldBe(clickable);
        this.addBaggageSecond.click();
    }

    @Step("Перейти к следующему шагу")
    public void nextStep() {
        this.nextStepButton.click();
    }
}
