import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        // Настройка пути к Chrome
        Configuration.holdBrowserOpen = true;
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        Configuration.browserCapabilities = options;

        // Настройка ChromeDriver
        WebDriverManager.chromedriver().driverVersion("138.0.7204.94").setup();

        // Выполнение теста
    open("/text-box");

    $("#userName").setValue("Dima Aparin");
    $("#userEmail").setValue("example@test.ss");
    $("#currentAddress").setValue("new adress");
    $("#permanentAddress").setValue("new value");
    $("#submit").click();

    $("[id=output]").shouldHave(text("Dima Aparin"), text("example@test.ss"),
            text("new adress"), text("new value"));
    }
}