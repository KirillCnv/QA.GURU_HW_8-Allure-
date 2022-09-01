package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.utils.ConfigTest;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends ConfigTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    private final SelenideElement
            sarchInput = $(".header-search-input"),
            issueTab = $("#issues-tab");


    @Test
    @Feature("Issue в репозитории(LambdaTest)")
    @Story("Создание Issue")
    @Owner("KirillCnv")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Проверка Issue для неавторизованного пользователя")
    public void testIssueSearch() {
        //SelenideLogger.addListener("allure", new AllureSelenide());


        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            sarchInput.click();
            sarchInput.sendKeys(REPOSITORY);
            sarchInput.submit();
        });

        step("Кликаем на " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issue", () -> {
            issueTab.click();
        });

        step("Проверяем номер Issue" + ISSUE, () -> {
            $(withText("#80")).should(Condition.exist);
        });

    }

}
