package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SelenideExtension implements BeforeAllCallback, AfterEachCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 70000;
        Configuration.pollingInterval = 200;
        Configuration.baseUrl = "https://cinescope.t-qa.ru";
    }
    @Override
    public void afterEach(ExtensionContext context) {
        Selenide.closeWebDriver();
    }
}
