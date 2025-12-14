package work.part02;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.devtools.v131.page.Page.close;

@TestMethodOrder (MethodOrderer.MethodName.class)

public class GitAutorization {

    @BeforeEach
    public void beforeEach(){
        open("https://github.com/login");
    }

    @Test
    public void testGit01LoginSuccess() {

        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000!");
        $(By.className("btn-primary")).click();
        $(By.className("Button-label")).shouldBe(visible);
        $(By.className("avatar")).click();
        $(By.id(":r10:")).click();
        $("input[name=commit]").click();

    }

    @Test
    public void testGit02LoginSuccess() {

        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000!");
        $(By.className("btn-primary")).click();
        $(By.className("avatar")).shouldBe(visible);
        $(By.className("avatar")).click();
        $(By.id(":r10:")).click();
        $("input[name=commit]").click();

    }

    @Test
    public void testGit03LoginSuccess() {

        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000!");
        $(By.className("btn-primary")).click();
        $(By.className("circle")).shouldBe(visible);
        $(By.className("avatar")).click();
        $(By.id(":r10:")).click();
        $("input[name=commit]").click();

    }

    @Test
    public void testGit04WrongPassword() {

        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000");
        $(By.className("btn-primary")).click();
        $(By.className("circle")).shouldNotBe(visible);

    }

    @Test
    public void testGit05WrongPassword() {

        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000");
        $(By.className("btn-primary")).click();
        $(By.className("f5")).shouldNotBe(visible);

    }

    @Test
    public void testGit06WrongPassword() {

        $("input[name=login]").setValue("AnnaMirgor");
        $("#password").sendKeys("Asd19092000");
        $(By.className("btn-primary")).click();
        $(By.className("flash-error")).shouldBe(visible);

    }
}
