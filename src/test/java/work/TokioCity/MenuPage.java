package work.TokioCity;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MenuPage {
    SelenideElement
            pizza = $x("//span[text()='Пицца']"),
            roll = $x("//span[text()='Роллы']"),
            soup = $x("//span[text()='Супы']");

    public void selectPizza() {
        this.pizza.click();
    }

    public void selectRoll() {
        this.roll.click();
    }

    public void selectSoup() {
        this.soup.click();
    }

}
