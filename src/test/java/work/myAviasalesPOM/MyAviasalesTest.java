package work.myAviasalesPOM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MyAviasalesTest {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        open("https://www.aviasales.ru/");
        getWebDriver().manage().window().maximize();
    }

    // 1. Поиск рейсов Москва-Санкт-Петербург, 17.01.2026-31.01.2026, 2 взрослых, 1 ребёнок, показать рекомендованный, оптимальный, самый дешёвый.
    @Test
    public void test01SuccessSearch () {

//        Configuration.pageLoadStrategy = "eager";
//        open("https://www.aviasales.ru/");
//        getWebDriver().manage().window().maximize();

        RoutePage routePage = new RoutePage();
        //Выбрать маршрут
        routePage.selectRoute("Санкт-Петербург");
        sleep(5_000);
        DatesPage datesPage = new DatesPage();
        //Отключить галочку в поле "Открыть Островок! в новой вкладке"
        datesPage.checkbox();
        //Выбрать даты
        datesPage.selectDates();
        //Выбрать количество пассажиров — 2 взрослых и 1 ребёнок
        datesPage.selectPassengersAdult();
        datesPage.selectPassengersChildren();
        //Нажать кнопку "Найти билеты"
        datesPage.findTickets();

        FlightsPage flightsPage = new FlightsPage();
        //Найти рейс с отметкой "Самый дешёвый", вывести на консоль цену
        flightsPage.findCheapestFlight();
        //Найти рейс с отметкой "Рекомендованный", вывести на консоль цену
        flightsPage.findRecommendedFlight();
        //Найти рейс с отметкой "Оптимальный", вывести на консоль цену
        flightsPage.findOptimalFlight();
    }

    // 2. Поиск рейсов Новосибирск-Москва, 17.01.2026-31.01.2026, 1 взрослый, самый дешёвый рейс с багажом
    @Test
    public void test02SuccessSearchWithBaggage () {

        RoutePage routePage = new RoutePage();
        //routePage.checkbox();
        //Выбрать маршрут
        routePage.selectRoute("Новосибирск", "Москва");
        sleep(5_000);
        DatesPage datesPage = new DatesPage();
        //Отключить галочку в поле "Открыть Островок! в новой вкладке"
        datesPage.checkbox();
        sleep(5_000);
        datesPage.checkbox();
        //Выбрать даты
        datesPage.selectDates();
        //Нажать кнопку "Найти билеты"
        datesPage.findTickets();
        sleep(5_000);
        FlightsPage flightsPage = new FlightsPage();
        //Отфильтровать рейсы с багажом
        flightsPage.withBaggage();
        sleep(5_000);
        //Найти рейс с отметкой "Самый дешёвый", вывести на консоль цену
        flightsPage.findCheapestFlight();

    }

    // 3. Багаж
    @Test
    public void test03Checkbox () {

        RoutePage routePage = new RoutePage();
        //Отключить галочку в поле "Открыть Островок! в новой вкладке"
        routePage.checkbox();
    }

}
