package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Specialist {
    @Test
    public void courses() {
        //open("https://www.specialist.ru/");
        //$x().click();
        open("https://www.specialist.ru/courses");
        $x("//*[@name='CourseName']").sendKeys("тестирование");
        $x("//*[@name='CourseName']").pressEnter();
        $x("//*[contains(.,'Автоматизированное тестирование веб-приложений с использованием Selenium')]").pressEnter();

    }
}
