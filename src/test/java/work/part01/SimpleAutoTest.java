package work.part01;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SimpleAutoTest {
    @Test
    void test04() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "800x400";
        Configuration.browserPosition = "100x500";

        open("http://92.51.36.108:7777/sl.qa");
//        SelenideElement a = $("body");
//        a.shouldHave(text("Учебные приложения"));

        $("body").shouldHave(text("Учебные приложения"));
        sleep(2000);
        getWebDriver().manage().window().maximize();
    }

    @Test
    void test05() {
        open("http://92.51.36.108:7777/sl.qa");
        $("body").shouldHave(text("Промышленные приложения"));
    }
}
