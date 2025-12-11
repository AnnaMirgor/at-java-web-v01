package work.part02;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MyFeeCalculationTest {
    @Test
    public void testFeeCalculation (){
        open("https://slqa.ru/cases/fc/v01/");

        //$(By.name("sum")).sendKeys("1000");
        $("input[name=sum]").sendKeys("1000");
        $(By.name("submit")).click();
        sleep(5000);
        $("input[name=sum]").setValue("2000");
        $(By.name("submit")).click();
        sleep(5000);
        $("input[name=sum]").type("2000");
        $(By.name("submit")).click();
        sleep(5000);
        $("input[name=sum]").clear();
    }
}
