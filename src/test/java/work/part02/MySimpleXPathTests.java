package work.part02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MySimpleXPathTests {
    @BeforeEach
    void setUp() {
        open("https://slqamsk.github.io/tmp/xPath01.html");
    }

    @Test
    void testPageH1() {
        //Содержит такой текст
        $x("//h1").shouldHave(text("Учебная страница для XPath"));
        //Точное соответствие
        $x("//h1").shouldHave(exactText("Учебная страница для XPath"));
    }

    @Test
    void testSpecialParagraph() {
        $x("//p[@class='special-paragraph']").shouldHave(exactText("Этот параграф особенный - он единственный на странице с таким классом."));
    }

    @Test
    void testFindByTexts() {
        open("https://slqa.ru/cases/xPathSimpleForm/");
        $(withText("Москва")).shouldHave(text("250 единиц"));
        $x("//*[contains(.,'Питер')]").shouldHave(text("180 единиц"));
        $x("//*[starts-with(.,'Казахстан')]").shouldHave(text("площадь 2 724 902"));
    }
}
