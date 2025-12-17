package work.part04;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class AT1 {

    @Test
    public void specialistHW () {

        Configuration.pageLoadStrategy = "eager";
        //Открыть сайт, в модальном окне "Наш сайт использует файлы cookie" нажать "Согласен"
        open("https://www.specialist.ru/");
        $("#cookieConsent__ok").pressEnter();
        //Выбрать пункт меню "Форматы обучения"
        $x("//*[text()='Форматы обучения']").pressEnter();
        //Выбрать раздел "Свободное обучение", нажать кнопку "Выбрать курс"
        $x("//*[contains(text(), 'Свободное обучение')]").pressEnter();
        $x("//*[contains(text(), 'Выбрать курс')]").pressEnter();
        //В поле "Направление" выбрать "Программирование", нажать кнопку "Применить"
        $("#Filter_CategoriesDirectionFilter").selectOptionByValue("ПРГ");
        //sleep(2_000);
        $("#sendBtn").click();
        //Убедиться, что на странице есть элемент содержащий текст "Тестирование ПО"
        $x("//*[contains(text(), 'Тестирование ПО')]").shouldBe(exist);
    }
}
