package work.part02;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MySearchTest {
    @Test
    public void testElementSearchMethods (){
        open("https://slqamsk.github.io/demo/search-demo/");

        By myLocator = By.id("submit-button");
        SelenideElement myElement = Selenide.element(myLocator);

        $(By.id("submit-button"));
        $(By.id("user-password"));

        $(By.name("interests"));
        $(By.name("user_email"));

        $(By.className("nav-link"));
        $(By.className("btn"));

        $(By.tagName("input"));
        $(By.tagName("h3"));

        $(By.linkText("Контакты и обратная связь"));
        $(By.linkText("Регистрация нового пользователя в системе"));

        $(By.partialLinkText("длинный"));
        $(By.partialLinkText("Контакты"));
    }
}
