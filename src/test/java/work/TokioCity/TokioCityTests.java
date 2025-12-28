package work.TokioCity;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;
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
    public void test01SelectCity (){
        CitySelectorPage citySelectorPage = new CitySelectorPage();
        citySelectorPage.selectCity("Санкт-Петербург");
    }

    // 2. Добавить в корзину рамен, гирос Лосось и ролл Филадельфия Роял
    @Test
    public void addItemsToBusket (){
        //Выбрать город Санкт-Петербург
        CitySelectorPage citySelectorPage = new CitySelectorPage();
        citySelectorPage.selectCity("Санкт-Петербург");
        //Выбрать пиццу Питерскую
        MenuPage menuPage = new MenuPage();
        menuPage.downloadPanel();
        menuPage.cookieAlert();
        menuPage.selectCategory("Пицца");
        menuPage.addItemToBasket("Пицца Питерская");
        menuPage.selectCategory("Супы");
        menuPage.addItemToBasket("Рамен");
        menuPage.selectCategory("Роллы");
        menuPage.addItemToBasket("Филадельфия с авокадо");
        sleep(5_000);
    }

    // 3. Октрыть категорию
    @Test
    public void selectCategory02 () {
        //Выбрать город Санкт-Петербург
        CitySelectorPage citySelectorPage = new CitySelectorPage();
        citySelectorPage.selectCity("Санкт-Петербург");
        //Выбрать пиццу Питерскую
        MenuPage menuPage = new MenuPage();
        menuPage.downloadPanel();
        menuPage.cookieAlert();
        $x("//div[@class='navbar']//span[contains(text(), 'Пицца')]")
                .shouldBe(Condition.interactable, Duration.ofSeconds(30));
        // Проверяем, что элемент interactable,
        //т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент не interactable
        $x("//div[@class='navbar']//span[contains(text(), 'Пицца')]")
                .shouldNotBe(Condition.readonly, Duration.ofSeconds(30));
        // Проверяем, что элемент доступен для записи,
        //т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент readonly
        $x("//div[@class='navbar']//span[contains(text(), 'Пицца')]").click();
        System.out.println("Выбрали категорию меню: " + $x("//span[@class= 'breadcrumbs__item']").text());
    }
}
