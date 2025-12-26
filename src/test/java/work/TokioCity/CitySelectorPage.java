package work.TokioCity;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CitySelectorPage {
//    SelenideElement
//            spb = $x("//button[text()='Санкт-Петербург']"),
//            msk = $x("//button[text()='Москва']"),
//            vnov = $x("//button[text()='Великий Новгород']");
        SelenideElement
                container = $x("//div[@class='citySelector__container']");

//    public void spb(){
//        this.spb.click();
//    }
//
//    public void msk(){
//        this.msk.click();
//    }
//
//    public void vnov(){
//        this.vnov.click();
//    }

    public void selectCity(String city){
        this.container.click();
        System.out.println("Выбрать город");

    }
}
