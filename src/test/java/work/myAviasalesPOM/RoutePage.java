package work.myAviasalesPOM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class RoutePage {

    SelenideElement
            checkbox = $x("//span[@class='s__u1BTPMyjvYPx48Gd']"),
            origin = $("#avia_form_origin-input"),
            destination = $("#avia_form_destination-input");

    @Step("Выбор маршрута")
    public void selectRoute(String cityFrom, String cityTo) {

        this.origin.shouldBe(Condition.interactable, Duration.ofSeconds(30)); // Проверяем, что элемент interactable,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент не interactable
        this.origin.shouldNotBe(Condition.readonly, Duration.ofSeconds(30)); // Проверяем, что элемент доступен для записи,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент readonly
        // В цикле мы тупо присваиваем значение, пока оно не присвоится.
        while (!Objects.equals(this.origin.getValue(), cityFrom)) {
            sleep(1_000);
            this.origin.click(); // Если кликнуть по этому полю, а потом перед тем, как присваивать значение очистить его,
            // то через какое-то время поле приходит в состояние, когда ему можно присвоить значение, которое требуется
            this.origin.setValue("").setValue(cityFrom);
        }
        sleep(1_000);
        this.destination.shouldBe(Condition.interactable, Duration.ofSeconds(30)); // Проверяем, что элемент interactable,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент не interactable
        this.destination.shouldNotBe(Condition.readonly, Duration.ofSeconds(30)); // Проверяем, что элемент доступен для записи,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент readonly
        this.destination.setValue(cityTo);

    }

    @Step("Выбор только города прибытия, если вылет из Москвы")
    public void selectRoute(String cityTo) {
        this.destination.click();
        this.destination.setValue(cityTo);
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
