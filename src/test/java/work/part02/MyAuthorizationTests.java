package work.part02;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MyAuthorizationTests {

    @BeforeEach
    void setUp() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
    }

    @Test
    public void test01LoginSuccess() {
        $("#username").sendKeys("standard_user");
        $("#password").sendKeys("stand_pass1");
        $("#loginButton").click();
        $("#flightForm").shouldBe(visible);

    }

    @Test
    public void test02LoginWrongPassword() {
        $(By.id("username")).sendKeys("standard_user");
        $("#password").sendKeys("stand_pass11");
        $("#loginButton").click();
        $("#flightForm").shouldNotBe(visible);

    }

    @Test
    public void test03LoginWrongPassword() {
        $(By.id("username")).sendKeys("standard_user");
        $("#password").sendKeys("stand_pass11");
        $("#loginButton").click();
        $(By.className("error")).shouldBe(visible);

    }

    @Test
    public void test04LoginWrongPassword() {
        $(By.id("username")).sendKeys("standard_user");
        $("#password").sendKeys("stand_pass11");
        $("#loginButton").click();
        $("#logoutButton").shouldNotBe(visible);

    }

    @Test
    public void test05LoginSuccess() {
        $(By.id("username")).sendKeys("standard_user");
        $("#password").sendKeys("stand_pass1");
        $("#loginButton").click();
        $("#logoutButton").shouldBe(visible);

    }
}
