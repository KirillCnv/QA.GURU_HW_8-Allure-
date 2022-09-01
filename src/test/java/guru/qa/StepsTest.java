package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.utils.ConfigTest;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsTest extends ConfigTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    @Feature("Issue в репозитории(annotated step test)")
    @Story("Создание Issue")
    @Owner("KirillCnv")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Проверка Issue для неавторизованного пользователя")
    public void testAnnotatedStep() {
        // SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }
}
