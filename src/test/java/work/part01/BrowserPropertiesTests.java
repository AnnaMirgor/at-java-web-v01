package work.part01;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class BrowserPropertiesTests {
    @Test
    void test01() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "800x400";
        Configuration.browserPosition = "100x500";
        open("http://92.51.36.108:7777/sl.qa");
    }
}
