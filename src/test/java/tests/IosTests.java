package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

@Owner("Klepova Elena")
@Feature("Text input and display")

public class IosTests extends TestBase{
    @Test
    @Tag("iOS")
    @DisplayName("Testing of text input and text desplaying")
    void enterTextTest() {
        step("Click Text button", () -> {
            $(id("Text Button")).click();
        });

        step("Click Enter a text field", () -> {
            $(id("Text Input")).click();
        });

        step("Enter Hello QA.GURU and click Enter", () -> {
            $(id("Text Input")).sendKeys("Quality assurance");
            $(id("Text Input")).pressEnter();
        });

        step("Check that text is displayed", () -> {
            $(AppiumBy.id("Text Output")).shouldHave(Condition.text("Quality assurance"));
        });
    }
}