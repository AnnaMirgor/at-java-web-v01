package work.part04;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AT05 {

    @Test
    public void aviasalesChrome () {

        Configuration.pageLoadStrategy = "eager";
        //Открыть сайт
        open("https://www.aviasales.ru/");
        getWebDriver().manage().window().maximize();
        //Configuration.timeout = 8_000;
        sleep(10_000);
        $("#avia_form_origin-input").click();
        //$("#avia_form_origin-input").sendKeys("");
        $("#avia_form_origin-input").type("Москва");
        //В поле "Куда" ввести "Санкт-Петербург"
        $("#avia_form_destination-input").type("Санкт-Петербург");
        sleep(5_000);
        //Отключить галочку в поле "Открыть Островок! в новой вкладке"
        $x("//span[@class='s__u1BTPMyjvYPx48Gd']").click();
        //Выбрать дату вылета 17.01.2026
        $x("//div[text()='Когда']").click();
        $x("//button[@aria-label='суббота, 17 января 2026 г.']").click();
        //Выбрать дату возвращения 31.01.2026
        $x("//div[text()='Обратно']").click();
        $x("//button[@aria-label='суббота, 31 января 2026 г.']").click();
        //Выбрать количество пассажиров — 2 взрослых и 1 ребёнок
        $x("//*[contains(text(), '1 пассажир')]").click();
        $x("//div[text()='Взрослые']/ancestor::div[@data-test-id='number-of-adults']//button[@data-test-id='increase-button']").click();
        $x("//div[text()='Дети']/ancestor::div[@data-test-id='number-of-children']//button[@data-test-id='increase-button']").click();
        //Нажать кнопку "Найти билеты"
        $x("//button[@data-test-id='form-submit']").click();
        Configuration.timeout = 20_000;

        //Найти рейс с отметкой "Самый дешёвый", вывести на консоль цену
        System.out.println("Цена самого дешёвого рейса: "
                + $x("//span[text()='Самый дешёвый']/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']").text());

        //Найти рейс с отметкой "Рекомендованный", вывести на консоль цену
        System.out.println("\nЦена рекомендованного рейса: "
                + $x("//span[text()='Рекомендуемый']/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']").text());

    }

    @Test
    public void aviasalesFirefox () {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "firefox";
        //Открыть сайт
        open("https://www.aviasales.ru/");
        getWebDriver().manage().window().maximize();
        //Дождаться появления окна "Вход через аккаунт Google" и закрыть его (это iframe)
        Configuration.timeout = 15_000;
        switchTo().frame($x("//div[@id='credential_picker_container']/iframe[@class='L5Fo6c-PQbLGe']"));
        $("#close").click();
        switchTo().defaultContent();

        //В поле "Куда" ввести "Санкт-Петербург"
        $("#avia_form_destination-input").click();
        $("#avia_form_destination-input").type("Санкт-Петербург");
        sleep(6_000);
        //Отключить галочку в поле "Открыть Островок! в новой вкладке"
        $x("//span[@class='s__u1BTPMyjvYPx48Gd']").click();
        //Выбрать дату вылета 17.01.2026
        sleep(3_000);
        $x("//div[text()='Когда']").click();
        sleep(6_000);
        $x("//button[@aria-label='суббота, 17 января 2026 г.']").click();
        //Выбрать дату возвращения 31.01.2026
        $x("//div[text()='Обратно']").click();
        $x("//button[@aria-label='суббота, 31 января 2026 г.']").click();
        //Выбрать количество пассажиров — 2 взрослых и 1 ребёнок
        $x("//*[contains(text(), '1 пассажир')]").click();
        $x("//div[text()='Взрослые']/ancestor::div[@data-test-id='number-of-adults']//button[@data-test-id='increase-button']").click();
        $x("//div[text()='Дети']/ancestor::div[@data-test-id='number-of-children']//button[@data-test-id='increase-button']").click();
        //Нажать кнопку "Найти билеты"
        $x("//button[@data-test-id='form-submit']").click();
        Configuration.timeout = 15_000;

        //Найти рейс с отметкой "Рекомендованный", вывести на консоль цену
        System.out.println("\nЦена рекомендованного рейса: "
                + $x("//span[text()='Рекомендуемый']/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']").text());

        //Найти рейс с отметкой "Самый дешёвый", вывести на консоль цену
        System.out.println("Цена самого дешёвого рейса: "
                + $x("//span[text()='Самый дешёвый']/ancestor::div[@data-test-id='ticket-preview']//div[@data-test-id='price']").text());

    }

    @Test
    public void aviasalesFirefoxDropdownVisible () {
        //Отдельный короткий тест, проверяем видимость полей для выбора даты, не работает

        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "firefox";
        //Открыть сайт
        open("https://www.aviasales.ru/");
        getWebDriver().manage().window().maximize();
        //Дождаться появления окна "Вход через аккаунт Google" и закрыть его (это iframe)
        Configuration.timeout = 10_000;
        switchTo().frame($x("//div[@id='credential_picker_container']/iframe[@class='L5Fo6c-PQbLGe']"));
        $("#close").click();
        switchTo().defaultContent();
        //В поле "Куда" ввести "Санкт-Петербург"
        Configuration.timeout = 8_000;
        $("#avia_form_destination-input").click();
        $("#avia_form_destination-input").type("Санкт-Петербург");
        sleep(6_000);
        //Отключить галочку в поле "Открыть Островок! в новой вкладке"
        $x("//span[@class='s__u1BTPMyjvYPx48Gd']").click();
        //Найти поле для выбора даты вылета, нажать, дождаться появления вариантов дат, не работает!!!
        //$x("//div[text()='Когда']").click();
        $x("//button[@data-test-id='start-date-field']").click();
        sleep(3_000);
        $x("//div[@data-test-id='dropdown']").shouldBe(visible);
    }

    @Test
    public void aviasalesEdge () {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "edge";
        //Открыть сайт — не работает!!!
        open("https://www.aviasales.ru/");
    }

}
