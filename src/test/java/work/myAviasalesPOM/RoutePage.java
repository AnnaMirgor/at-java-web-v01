package work.myAviasalesPOM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class RoutePage {

    SelenideElement
            checkbox = $x("//span[@class='s__u1BTPMyjvYPx48Gd']"),
            origin = $("#avia_form_origin-input"),
            destination = $("#avia_form_destination-input");

    @Step("Выбор городов вылета и прибытия")
    public void choosingRoute(String origin, String destination) {
        this.origin.click();
        this.origin.type(origin);
        this.destination.click();
        this.destination.type(destination);
        //Configuration.timeout = 10_000;
    }

    @Step("Выбор только города прибытия, если вылет из Москвы")
    public void choosingRoute(String destination) {
        this.destination.click();
        this.destination.type(destination);
        //Configuration.timeout = 10_000;
    }

    @Step("Чекбокс Островок")
    public void checkbox() {
        this.checkbox.shouldBe(Condition.interactable, Duration.ofSeconds(30)); // Проверяем, что элемент interactable,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент не interactable
        this.checkbox.shouldNotBe(Condition.readonly, Duration.ofSeconds(30)); // Проверяем, что элемент доступен для записи,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент readonly
        this.checkbox.click();
    }

}
