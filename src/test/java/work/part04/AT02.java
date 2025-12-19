package work.part04;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AT02 {

    @Test
    public void cinema01 () {
        //Проверка, что все скидки суммируются.
        //1. Открыть форму
        //2. Выбрать возраст 4 года
        //3. Выбрать первый утренний сеанс
        //4. Выбрать будний день
        //5. Выбрать фильм категории 0+
        //6. Нажать кнопку "Рассчитать"
        //7. Убедиться, что стоимость билета 500 - 250 - 100 - 50 = 100 рублей.
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $("input[name=age]").type("4");
        $("input[name=date]").sendKeys("22122025");
        $("input[name=session][value='1']").click();
        $("input[name=film][value='king']").click();
        $x("//input[@value='Рассчитать']").click();
        $x("//*[contains(text(), '100 рублей')]").shouldBe(visible);
    }

    @Test
    public void cinema02 () {
        //Проверка, что нельзя рассчитать стоимость сеанса, если возраст не соответствует ограничению.
        //1. Открыть форму
        //2. Выбрать возраст 15 лет
        //3. Выбрать любой сеанс
        //4. Выбрать любую дату в течение недели, начиная с завтрашнего дня
        //5. Выбрать фильм категории 18+
        //6. Нажать кнопку "Рассчитать"
        //7. Убедиться, что выводится сообщение о неподходящем возрасте.
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $("input[name=age]").type("15");
        $("input[name=date]").sendKeys("24122025");
        $("input[name=session][value='5']").click();
        $(By.name("film")).selectRadio("killers");
        $x("//input[@value='Рассчитать']").click();
        $x("//*[contains(text(), 'Этот фильм можно смотреть только с 18 лет')]").shouldBe(visible);
    }

    @Test
    public void cinema03 () {
        //Проверка, что стоимость без скидок сотставляет 500 рублей.
        //1. Открыть форму
        //2. Выбрать возраст 25 лет
        //3. Выбрать любой сеанс с 14:00 и позднее
        //4. Выбрать выходной день
        //5. Выбрать любой фильм
        //6. Нажать кнопку "Рассчитать"
        //7. Убедиться, что стоимость билета 500 рублей.
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $("input[name=age]").type("25");
        $("input[name=date]").sendKeys("21122025");
        $("input[name=session][value='4']").click();
        $(By.name("film")).selectRadio("killers");
        $x("//input[@value='Рассчитать']").click();
        $x("//*[contains(text(), '500 рублей')]").shouldBe(visible);
    }

    @Test
    public void cinema04 () {
        //Проверка, что стоимость без скидок сотставляет 500 рублей.
        //1. Открыть форму
        //2. Выбрать возраст 100 лет
        //3. Выбрать любой сеанс
        //4. Выбрать любую дату в течение недели, начиная с завтрашнего дня
        //5. Выбрать любой фильм
        //6. Нажать кнопку "Рассчитать"
        //7. Убедиться, что стоимость не может быть рассчитана.
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $("input[name=age]").type("100");
        $("input[name=date]").sendKeys("21122025");
        $("input[name=session][value='4']").click();
        $(By.name("film")).selectRadio("killers");
        $x("//input[@value='Рассчитать']").click();
        $x("//*[contains(text(), 'нажмите кнопку для расчёта')]").shouldBe(visible);
    }

    @Test
    public void cinema05 () {
        //Проверка, что на сегодняшний день билет купить нельзя.
        //1. Открыть форму
        //2. Выбрать любой возраст до 99 лет включительно
        //3. Выбрать любой сеанс
        //4. Выбрать сегодняшнюю дату
        //5. Выбрать любой фильм
        //6. Нажать кнопку "Рассчитать"
        //7. Убедиться, что стоимость не может быть рассчитана.
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $("input[name=age]").type("45");
        $("input[name=date]").sendKeys("19122025");
        $("input[name=session][value='1']").click();
        $(By.name("film")).selectRadio("back");
        $x("//input[@value='Рассчитать']").click();
        $x("//*[contains(text(), 'нажмите кнопку для расчёта')]").shouldBe(visible);
    }

    @Test
    public void cinema06 () {
        //Проверка, что, если какие-то из полей не заполнены, то при нажатии кнопки "Рассчитать"
        //вместо стоимости билета выводится сообщение о том, какие поля не заполнены.
        //1. Открыть форму
        //2. Не выбирать возраст
        //3. Выбрать любой сеанс
        //4. Выбрать любую дату в течение недели, начиная с завтрашнего дня
        //5. Выбрать любой фильм
        //6. Нажать кнопку "Рассчитать"
        //7. Убедиться, что в сообщении указано, какое поле не заполнено.
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $("input[name=date]").sendKeys("20122025");
        $("input[name=session][value='8']").click();
        $(By.name("film")).selectRadio("back");
        $x("//input[@value='Рассчитать']").click();
        $x("//*[contains(text(), 'надо указать возраст для расчёта стоимости билета')]").shouldBe(visible);
    }

    @Test
    public void cinema07 () {
        //Проверка, что на сеансы ждо 14:00 скидка 50 рублей.
        //1. Открыть форму
        //2. Выбрать возраст 45 лет
        //3. Выбрать сеанс до 14:00
        //4. Выбрать выходной день
        //5. Выбрать любой фильм
        //6. Нажать кнопку "Рассчитать"
        //7. Убедиться, что стоимость билета 450 рублей.
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $("input[name=age]").type("45");
        $("input[name=date]").sendKeys("20122025");
        $("input[name=session][value='3']").click();
        $(By.name("film")).selectRadio("back");
        $x("//input[@value='Рассчитать']").click();
        $x("//*[contains(text(), '450 рублей')]").shouldBe(visible);
    }
}
