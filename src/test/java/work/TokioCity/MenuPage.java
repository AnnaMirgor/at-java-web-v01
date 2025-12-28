package work.TokioCity;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class MenuPage {
    SelenideElement
            busket = $x("//button[@class='header__basketButton']"),
            busketClose = $x("//button[@class='basket__close']"),
            cookie = $x("//button[text()='Принять']"),
            download = $x("//button[@class='downloadPanel__close']"),
            logo = $x("//div[@class='navbar__logo']");

    public void cookieAlert(){
        this.cookie.shouldBe(Condition.interactable, Duration.ofSeconds(30)); // Проверяем, что элемент interactable,
        //т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент не interactable
        this.cookie.shouldNotBe(Condition.readonly, Duration.ofSeconds(30)); // Проверяем, что элемент доступен для записи,
        //т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент readonly
        this.cookie.click();
    }

    public void downloadPanel(){
        this.download.shouldBe(Condition.interactable, Duration.ofSeconds(30)); // Проверяем, что элемент interactable,
        //т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент не interactable
        this.download.shouldNotBe(Condition.readonly, Duration.ofSeconds(30)); // Проверяем, что элемент доступен для записи,
        //т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент readonly
        this.download.click();
    }

    public void selectCategory(String category){
        $x("//div[@class='navbar']//span[contains(text(), '" + category + "')]")
                .shouldBe(Condition.interactable, Duration.ofSeconds(30));
        // Проверяем, что элемент interactable,
        //т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент не interactable
        $x("//div[@class='navbar']//span[contains(text(), '" + category + "')]")
                .shouldNotBe(Condition.readonly, Duration.ofSeconds(30));
        // Проверяем, что элемент доступен для записи,
        //т.е. с ним можно взаимодействовать - добавил, т.к. возникали ошибки, что элемент readonly
        $x("//div[@class='navbar']//span[contains(text(), '" + category + "')]").click();
        System.out.println("Выбрали категорию меню: " + $x("//span[@class= 'breadcrumbs__item']").text());
    }

    public void addItemToBasket(String title){
        $x("//p[contains(text(), '"
                + title + "')]/ancestor::div[@class='dishesItem__content']//button[text()='В корзину']")
                .shouldBe(Condition.interactable, Duration.ofSeconds(30));
        $x("//p[contains(text(), '"
                + title + "')]/ancestor::div[@class='dishesItem__content']//button[text()='В корзину']")
                .shouldNotBe(Condition.readonly, Duration.ofSeconds(30));
        $x("//p[contains(text(), '"
                + title + "')]/ancestor::div[@class='dishesItem__content']//button[text()='В корзину']").click();
        this.busket.click();
        $x("//div[@class='name caption1']").shouldHave(text(title));
        this.busketClose.click();
        System.out.println("Добавили в корзину блюдо: " + title);
        this.logo.click();
    }

}
