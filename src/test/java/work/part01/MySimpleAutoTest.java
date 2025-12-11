package work.part01;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MySimpleAutoTest {
    @Test
    void test04() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "800x400";
        Configuration.browserPosition = "100x500";

        open("http://92.51.36.108:7777/sl.qa");
        $("body").shouldHave(text("Учебные приложения"));
    }

    @Test
    void test05() {
        open("http://92.51.36.108:7777/sl.qa");
        //Можно отдельно создавать элемент класса, потом к нему применять метод
        //А можно сразу в одной строке создавать элемент и через точку прописывать метод
        SelenideElement a = $("body");
        a.shouldHave(text("Промышленные приложения"));
        $("body").shouldHave(text("Промышленные приложения"));
    }
}
