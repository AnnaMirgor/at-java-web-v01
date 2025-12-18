package work.part04;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AT05 {

    @Test
    public void aviasalesHW () {

        Configuration.pageLoadStrategy = "eager";
        //Configuration.browser = "firefox";
        //Configuration.pageLoadTimeout = 30_000;
        //Открыть сайт
        open("https://www.aviasales.ru/");
        sleep(6_000);
        //Configuration.timeout = 5_000;
        $("#avia_form_destination-input").type("Санкт-Петербург");
        sleep(6_000);

        $x("//span[@class='s__u1BTPMyjvYPx48Gd']").click();

        //$x("//div[@class='Bz112c-ZmdkE']").click();
        //sleep(2_000);
        //$("#avia_form_origin-input").sendKeys("Москва");
        Configuration.timeout =5_000;

        $x("//div[text()='Когда']").click();
        //sleep(1_000);
        $x("//button[@aria-label='суббота, 17 января 2026 г.']").click();

        $x("//div[text()='Обратно']").click();
        //sleep(1_000);
        $x("//button[@aria-label='суббота, 31 января 2026 г.']").click();

        $x("//*[contains(text(), '1 пассажир')]").click();
        //sleep(1_000);
        $x("//div[text()='Взрослые']/../../div[2]/div[3]/button").click();
        //sleep(1_000);
        $x("//div[text()='Дети']/../../div[2]/div[3]/button").click();
        //sleep(1_000);

        $x("//button[@data-test-id='form-submit']").click();
        //sleep(2_000);

        Configuration.timeout = 10_000;
        //sleep(5_000);
        $x("//span[text()='Рекомендуемый']").shouldBe(visible);

    }

    @Test
    public void aviasalesHW2 () {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "firefox";
        //Configuration.pageLoadTimeout = 30_000;
        //Открыть сайт
        open("https://www.aviasales.ru/search/MOW1701LED310121");
        Configuration.timeout = 10_000;
        $x("//span[text()='Рекомендуемый']").shouldBe(visible);
    }

    @Test
    public void aviasalesHW3 () {

        Configuration.pageLoadStrategy = "eager";
        //Configuration.browser = "firefox";

        //Открыть сайт
        open("https://www.aviasales.ru/");

        Configuration.timeout = 10_000;

        $("#close").shouldBe(visible);
    }

}
