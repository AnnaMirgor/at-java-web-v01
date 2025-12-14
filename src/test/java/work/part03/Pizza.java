package work.part03;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Pizza {
    @Test
    public void addPizza() {
        open("https://slqamsk.github.io/cases/pizza/v08/");
        SelenideElement se1 = $x("/h3[.='Маргарита']");
        System.out.println("Элемент с названием пиццы: тег: " + se1.getTagName() + ", текст:" + se1.text());

    }
}
