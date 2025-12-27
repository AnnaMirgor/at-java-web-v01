package work.myAviasalesPOM;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class FlightsPage {

    SelenideElement
            withBaggage = $x("//span[text()='С багажом']"),
            recommended = $x("//span[text()='Рекомендуемый']/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']"),
            optimal = $x("//span[text()='Оптимальный']/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']"),
            cheapest = $x("//span[text()='Самый дешёвый']/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']"),
            cheapestWithBaggage = $x("//span[contains(text(), 'Самый дешёвый с')]/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']");


    @Step("Поиск самого дешёвого рейса")
    public void findCheapestFlight() {
        System.out.println("Цена самого дешёвого рейса: " + this.cheapest.text());
    }

    @Step("Поиск самого дешёвого рейса с багажом")
    public void findCheapestFlightWithBaggage() {
        System.out.println("Цена самого дешёвого рейса с багажом: " + this.cheapestWithBaggage.text()); }

    @Step("Поиск рекомендованного рейса")
    public void findRecommendedFlight() {
        System.out.println("Цена рекомендованного рейса: " + this.recommended.text()); }

    @Step("Поиск оптимального рейса")
    public void findOptimalFlight() {
        System.out.println("Цена оптимального рейса: " + this.optimal.text());
    }

    @Step("Поиск самого дешёвого рейса")
    public void withBaggage() {
        this.withBaggage.click();
    }

}
