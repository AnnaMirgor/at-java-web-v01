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

    @Step("Замена города вылета")
    public void changeCityFrom(String cityFrom) {

        origin.shouldBe(Condition.interactable, Duration.ofSeconds(30)); // Проверяем, что элемент interactable,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент не interactable
        origin.shouldNotBe(Condition.readonly, Duration.ofSeconds(30)); // Проверяем, что элемент доступен для записи,
        // т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент readonly
        System.out.println(origin.getValue());
        origin.setValue(cityFrom); // Иногда срабатывает прямо так
        System.out.println(origin.getValue());
        // В цикле мы тупо присваиваем значение, пока оно не присвоится.
        // Конечно, надо добавить ограничение на число попыток, чтобы не было бесконечного цикла
        // Например, цикл for от 1 до 100, а потом, если значение не присвоено, то выбрасывать ошибку
        while (!Objects.equals(origin.getValue(), cityFrom)) {
            sleep(1_000);
            origin.click(); // Если кликнуть по этому полю, а потом перед тем, как присваивать значение очистить его,
            // то через какое-то время поле приходит в состояние, когда ему можно присвоить значение, которое требуется
            origin.setValue("").setValue(cityFrom);
            System.out.println(origin.getValue());
        }
    }

    @Step("Выбор городов вылета и прибытия")
    public void selectRoute(String origin, String destination) {
        this.origin.click();
        this.origin.type(origin);
        this.destination.click();
        this.destination.type(destination);
        //Configuration.timeout = 10_000;
    }

    @Step("Выбор только города прибытия, если вылет из Москвы")
    public void selectRoute(String destination) {
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
