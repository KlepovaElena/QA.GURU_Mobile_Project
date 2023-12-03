package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.DeviceHostConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = DeviceHostConfig.getConfig();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    public void beforeEach(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        if(System.getProperty("deviceHost", "emulation").equals("emulation")) {
            Attach.screenshotAs("Last screenshot");
        }

        Attach.pageSource();

        String sessionId = Selenide.sessionId().toString();
        closeWebDriver();

        if(System.getProperty("deviceHost", "emulation").equals("browserstack")){
            Attach.addVideo(sessionId);
        }
    }
}