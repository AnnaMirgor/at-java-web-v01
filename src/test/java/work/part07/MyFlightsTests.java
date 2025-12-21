package work.part07;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MyFlightsTests {

    @Test
    public void flightsTest01WrongLogin () {
        Configuration.pageLoadStrategy = "eager";
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $("#username").sendKeys("standard_user_wrong");
        $("#password").sendKeys("stand_pass1");
        $("#loginButton").click();
        $("#flightForm").shouldNotBe(visible);
    }

    @Test
    public void flightsTest02NotDate () {
        Configuration.pageLoadStrategy = "eager";
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $("#username").sendKeys("standard_user");
        $("#password").sendKeys("stand_pass1");
        $("#loginButton").click();
        $("#departureDate").setValue("");
        $x("//button[@onclick='findFlights()']").click();
        $("#flightsList").shouldNotBe(visible);

    }

    @Test
    public void flightsTest03NotFoundFlight () {
        Configuration.pageLoadStrategy = "eager";
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $("#username").sendKeys("standard_user");
        $("#password").sendKeys("stand_pass1");
        $("#loginButton").click();
        $("#departureCity").click();
        $("#departureCity").selectOption("Казань");
        $("#departureCity").click();
        $("#arrivalCity").selectOption("Париж");
        $("#departureDate").sendKeys("22.12.2025");
        $x("//button[@onclick='findFlights()']").click();
        $x("//td[@colspan='7']").shouldHave(text("Рейсов по вашему запросу не найдено."));

    }
    @Test
    public void flightsTest04NotFoundFlight () {
        Configuration.pageLoadStrategy = "eager";
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $("#username").sendKeys("standard_user");
        $("#password").sendKeys("stand_pass1");
        $("#loginButton").click();
        $("#departureCity").click();
        $("#departureCity").selectOption("Москва");
        $("#departureCity").click();
        $("#arrivalCity").selectOption("Нью-Йорк");
        $("#departureDate").sendKeys("23.12.2025");
        $x("//button[@onclick='findFlights()']").click();
        $x("//button[@class='register-btn']").click();
        //$x("//td[@colspan='7']").shouldHave(text("Рейсов по вашему запросу не найдено."));

    }
}
