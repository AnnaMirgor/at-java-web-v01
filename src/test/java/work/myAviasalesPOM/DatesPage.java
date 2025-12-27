package work.myAviasalesPOM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class DatesPage {

    SelenideElement
            //startDateField = $x("//div[text()='Когда']"),
            checkbox = $x("//span[@class='s__u1BTPMyjvYPx48Gd']"),
            startDateField = $x("//div[@class='s__haCTfA3JViwhTtfy']"),
            endDateField = $x("//div[text()='Обратно']"),
            dateFirst = $x("//button[@aria-label='суббота, 17 января 2026 г.']"),
            dateSecond = $x("//button[@aria-label='суббота, 31 января 2026 г.']"),
            passengersNumbers = $x("//*[contains(text(), '1 пассажир')]"),
            adultsNumbers = $x("//div[text()='Взрослые']/ancestor::div[@data-test-id='number-of-adults']//button[@data-test-id='increase-button']"),
            childrenNumbers = $x("//div[text()='Дети']/ancestor::div[@data-test-id='number-of-children']//button[@data-test-id='increase-button']"),
            buttonFind = $x("//button[@data-test-id='form-submit']");

    @Step("Чекбокс Островок")
    public void checkbox() {
        //this.checkbox.shouldBe(Condition.interactable, Duration.ofSeconds(30)); // Проверяем, что элемент interactable,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент не interactable
        //this.checkbox.shouldNotBe(Condition.readonly, Duration.ofSeconds(30)); // Проверяем, что элемент доступен для записи,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент readonly
        this.checkbox.click();
    }

    @Step("Выбор дат")
    public void selectDates() {
        this.startDateField.click();
        this.dateFirst.click();
        this.endDateField.click();
        this.dateSecond.click();
    }

    @Step("Выбор взрослых пассажиров")
    public void selectPassengersAdult() {
        this.passengersNumbers.click();
        this.adultsNumbers.click();
    }

    @Step("Выбор пассажиров детей")
    public void selectPassengersChildren() {
        this.childrenNumbers.click();
    }

    @Step("Поиск билетов")
    public void findTickets() {
        this.buttonFind.click();
        Configuration.timeout = 20_000;
    }

}
