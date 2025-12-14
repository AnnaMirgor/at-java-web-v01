package work.part05;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MyParameterizedTest {

    @ParameterizedTest()
    @ValueSource(strings = {"100", "2000", "qwerty"})
    void test01(String sum) {
        open("https://slqa.ru/cases/fc/v01/");
        $("[name=sum]").type(sum);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "login_test.csv", numLinesToSkip=1)
    void test02(String username, String password) {
        Configuration.pageLoadStrategy = "eager";
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $("#username").sendKeys(username);
        $("#password").sendKeys(password);
        $("#loginButton").pressEnter();
        $("#logoutButton").shouldBe(visible);
        $("#logoutButton").pressEnter();
    }
}
