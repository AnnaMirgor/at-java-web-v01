package work.aviasalesPOM;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ChoosingRoutePage {

    SelenideElement
            checkbox = $x("//span[@class='s__u1BTPMyjvYPx48Gd']"),
            origin = $("#avia_form_origin-input"),
            destination = $("#avia_form_destination-input");

    @Step("Выбор маршрута")
    public void choosingRoute(String origin, String destination) {
        this.origin.click();
        this.origin.type(origin);
        this.destination.click();
        this.destination.type(destination);
        //Configuration.timeout = 10_000;
        sleep(5_000);
    }

    @Step("Чекбокс Островок")
    public void checkbox() {
        this.checkbox.click();
    }

}
