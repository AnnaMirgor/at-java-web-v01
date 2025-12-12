package work.part02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.devtools.v131.page.Page.close;

public class GitAutorization {

//    @BeforeEach
//    public void beforeEach(){
//        open("https://github.com/login");
//    }

//    @AfterEach
//    public void afterEach(){
//
//    }

    @Test
    public void testGit01() {
        open("https://github.com/login");
        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000!");
        $(By.className("btn-primary")).click();
        $(By.className("Button-label")).shouldBe(visible);

    }

    @Test
    public void testGit02() {
        open("https://github.com/login");
        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000!");
        $(By.className("btn-primary")).click();
        $(By.className("avatar")).shouldBe(visible);

    }

    @Test
    public void testGit03() {
        open("https://github.com/login");
        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000!");
        $(By.className("btn-primary")).click();
        $(By.className("circle")).shouldBe(visible);

    }

    @Test
    public void testGit04() {
        open("https://github.com/login");
        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000");
        $(By.className("btn-primary")).click();
        $(By.className("circle")).shouldNotBe(visible);

    }

    @Test
    public void testGit05() {
        open("https://github.com/login");
        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000");
        $(By.className("btn-primary")).click();
        $(By.className("f5")).shouldNotBe(visible);

    }

    @Test
    public void testGit06() {
        open("https://github.com/login");
        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000");
        $(By.className("btn-primary")).click();
        $(By.className("flash-error")).shouldBe(visible);

    }
}
