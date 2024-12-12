/* автор Терещенков Никита Сергеевич
 *
 * Задание по 5-й лекции
 */
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import  org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TestingLesson {

    @BeforeClass
    void init() {
        Configuration.baseUrl = "https://simmolprom.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
    }

    @Test
    public void test1() {
        open("");
        $(By.xpath("//*[contains(@class,'nav__link link-3')]"))
                .shouldBe(visible)
                .shouldHave(text("Продукция"))
                .click();
        $(By.xpath("//*[text()='Молокосодержащие продукты']"))
                .shouldBe(visible)
                .click();
        $(By.xpath("//*[contains(@src,'img/product-8.png')]"))
                .shouldBe(visible);
        sleep(5000);
    }
}
