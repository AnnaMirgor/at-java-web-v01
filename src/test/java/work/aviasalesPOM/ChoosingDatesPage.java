package work.aviasalesPOM;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ChoosingDatesPage {

    SelenideElement
            startDateField = $x("//div[text()='Когда']"),
            endDateField = $x("//div[text()='Обратно']"),
            dateFirst = $x("//button[@aria-label='суббота, 17 января 2026 г.']"),
            dateSecond = $x("//button[@aria-label='суббота, 31 января 2026 г.']"),
            passengersNumbers = $x("//*[contains(text(), '1 пассажир')]"),
            adultsNumbers = $x("//div[text()='Взрослые']/ancestor::div[@data-test-id='number-of-adults']//button[@data-test-id='increase-button']"),
            childrenNumbers = $x("//div[text()='Дети']/ancestor::div[@data-test-id='number-of-children']//button[@data-test-id='increase-button']"),
            buttonFind = $x("//button[@data-test-id='form-submit']"),
            recommended = $x("//span[text()='Рекомендуемый']/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']"),
            cheapest = $x("//span[text()='Рекомендуемый']/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']");

    @Step("Выбор дат")
    public void сhoosingDates() {
        this.startDateField.click();
        this.dateFirst.click();
        this.endDateField.click();
        this.dateSecond.click();
    }

    @Step("Выбор взрослых пассажиров")
    public void сhoosingPassengersAdult() {
        this.passengersNumbers.click();
        this.adultsNumbers.click();
    }

    @Step("Выбор пассажиров детей")
    public void сhoosingPassengersChildren() {
        this.childrenNumbers.click();
    }

    @Step("Поиск билетов")
    public void findTickets() {
        this.buttonFind.click();
        Configuration.timeout = 20_000;
    }

    @Step("Поиск самого дешёвого рейса")
    public void findCheapestFlight() {
        System.out.println("Цена самого дешёвого рейса: " + this.cheapest.text());
    }

    @Step("Поиск рекомендованного рейса")
    public void findRecommendedFlight() {
        System.out.println("Цена рекомендованного рейса: " + this.recommended.text());
    }

}
