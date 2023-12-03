package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.OnboardingPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThanOrEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

@Owner("Klepova Elena")
@Feature("Wikipedia")

public class AndroidTests extends TestBase {

    OnboardingPage onboardingPage= new OnboardingPage();

    @Test
    @Tag("emulation")
    @DisplayName("Testing of onboarding and searching Wikipedia")
    void onboardingTest() {

        onboardingPage.checkPageHeading("The Free Encyclopedia")
                .tapForward()
                .checkPageHeading("New ways to explore")
                .tapForward()
                .checkPageHeading("Reading lists with sync")
                .tapForward()
                .checkPageHeading("Send anonymous data")
                .tapReject();

        step("Check result", () -> {
            $(accessibilityId("Search Wikipedia")).shouldBe(visible);
        });
    }


    @Test
    @Tag("Android")
    @Tag("emulation")
    @DisplayName("Testing of successful search in Wikipedea")
    void successfulSearchTest() {
        step("Skip onboarding", () -> {
            if($(id("org.wikipedia.alpha:id/primaryTextView")).isDisplayed()){
                back();
            }
        });

        step("Execute searching", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Quality Assurance");
        });

        step("Check search result", () ->
                $$(className("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("Android")
    @DisplayName("Testing of Quality assuranceeee search in Wikipedia")
    void unsuccessfulSearchBrowserstackTest() {
        step("Search Quality assurance in Wikipedia", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Quality assuranceeeee");
        });
        step("Check Quality assurance is not found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeLessThanOrEqual(0)));
    }

    @Test
    @Tag("Android")
    @DisplayName("Testing of error when opening a found article")
    void errorWhenOpeningArticleBrowserstackTest() {
        step("Skip onboarding", () -> {
            if($(id("org.wikipedia.alpha:id/primaryTextView")).isDisplayed()){
                back();
            }
        });

        step("Execute searching", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Quality Assurance");
        });

        step("Check search content", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));

        step("Open the first article", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_container")).first().click());

        step("Error is displayed", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldBe(visible);
        });
    }
}