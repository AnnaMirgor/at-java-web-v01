package work.aviasalesPOM;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AviasalesTest {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        open("https://www.aviasales.ru/");
        getWebDriver().manage().window().maximize(); }

    @Test
    public void aviasalesChrome () {

        ChoosingRoutePage choosingRoutePage = new ChoosingRoutePage();
        //Отключить галочку в поле "Открыть Островок! в новой вкладке"
        choosingRoutePage.checkbox();
        //Выбрать маршруты
        choosingRoutePage.choosingRoute("Москва", "Санкт-Петербург");

        ChoosingDatesPage choosingDatesPage = new ChoosingDatesPage();
        //Выбрать даты
        choosingDatesPage.сhoosingDates();
        //Выбрать количество пассажиров — 2 взрослых и 1 ребёнок
        choosingDatesPage.сhoosingPassengersAdult();
        choosingDatesPage.сhoosingPassengersChildren();
        //Нажать кнопку "Найти билеты"
        choosingDatesPage.findTickets();
        //Найти рейс с отметкой "Самый дешёвый", вывести на консоль цену
        choosingDatesPage.findCheapestFlight();
        //Найти рейс с отметкой "Рекомендованный", вывести на консоль цену
        choosingDatesPage.findRecommendedFlight();
    }
}
