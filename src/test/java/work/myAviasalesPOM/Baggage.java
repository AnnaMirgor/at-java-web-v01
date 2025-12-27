package work.myAviasalesPOM;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Baggage {

    @Test
    public void testBaggage () {

        Configuration.pageLoadStrategy = "eager";
        open("https://www.aviasales.ru/search/OVB1701MOW31011");
        getWebDriver().manage().window().maximize();

        sleep(10_000);
        FlightsPage flightsPage = new FlightsPage();
        //$x("//span[text()='С багажом']").click();
        //Отфильтровать рейсы с багажом
        flightsPage.withBaggage();
        sleep(10_000);
        //Найти рейс с отметкой "Самый дешёвый", вывести на консоль цену
        flightsPage.findCheapestFlightWithBaggage();

    }
}
