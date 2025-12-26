package work.TokioCity;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TokioCityTests {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        open("https://www.tokyo-city.ru/");
        getWebDriver().manage().window().maximize();
    }

    // 1. Выбираем город "Санкт-Петербург"
    @Test
    public void selectSpb (){
        CitySelectorPage citySelectorPage = new CitySelectorPage();
        //citySelectorPage.spb();
    }

    // 2. Добавить в корзину рамен, пиццу Питерскую и ролл Филадельфия Роял
    @Test
    public void addItemsToBusket (){
        //Выбрать город Санкт-Петербург
        CitySelectorPage citySelectorPage = new CitySelectorPage();
        //citySelectorPage.spb();

    }
}
