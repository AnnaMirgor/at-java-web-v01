package work.part02;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Specialist {
    @Test
    public void courses() {

        Configuration.pageLoadStrategy = "eager";
        //Открыть сайт
        open("https://www.specialist.ru/");
        getWebDriver().manage().window().maximize();
        //В модальном окне "Наш сайт использует файлы cookie" нажать "Согласен"
        $("#cookieConsent__ok").pressEnter();
        $x("//a[.='Курсы']").click();
        sleep(3_000);
        //Configuration.timeout = 5_000;
        //$x("//*[contains(text(), 'Каталог курсов')]").click();
        $x("//a[.='Каталог курсов']").click();
        $x("//input[@name='CourseName']").sendKeys("тестирование");
        $x("//input[@name='CourseName']").pressEnter();
        Configuration.timeout = 4_000;
        $x("//a[contains(.,'Автоматизированное тестирование веб-приложений с использованием Selenium')]/ancestor::article//dd[contains(@class,'date-start')]")
                .shouldHave(text("24.01.2026"));
        //a[contains(.,'Автоматизированное тестирование веб-приложений с использованием Selenium')]/../../../..//dd[contains(text(), '24.01.2026']
    }
}
