package work.part02;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class MyNavigationTests {
    @Test
    void testNavigation() {
        open("https://ya.ru/");
        sleep(3000);
        open("https://ru.wikipedia.org");
        sleep(3000);
        open("https://ru.wikipedia.org/wiki/Selenium");
        sleep(3000);
        back();
        sleep(3000);
        back();
        sleep(3000);
        forward();
        sleep(3000);
    }
}
