package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingPage {
    private SelenideElement
            primaryTextView = $(id("org.wikipedia.alpha:id/primaryTextView")),
            forwardButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            rejectButton =  $(id("org.wikipedia.alpha:id/rejectButton"));

    @Step("Check page heading")
    public OnboardingPage checkPageHeading(String value){
        primaryTextView.shouldHave(Condition.text(value));
        return this;
    }

    @Step("Click Forward button")
    public OnboardingPage tapForward(){
        forwardButton.click();
        return this;
    }

    @Step("Click Reject button")
    public OnboardingPage tapReject(){
        rejectButton.click();
        return this;
    }
}