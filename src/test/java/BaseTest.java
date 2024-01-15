import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import static com.codeborne.selenide.Configuration.baseUrl;


public class BaseTest {


    @BeforeAll
    public static void beforeMethod(){
        System.setProperty("loadType","local");
        WebDriverConfig WebDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        baseUrl = WebDriverConfig.getBaseUrl();
        Configuration.browser = WebDriverConfig.getBrowser();
        Configuration.browserSize = WebDriverConfig.browserSize();
        Configuration.pageLoadStrategy = WebDriverConfig.loadStrategy();
        Configuration.browserVersion = WebDriverConfig.browserVersion();

        if(WebDriverConfig.remoteLoad().equals("true")){
            Configuration.remote = WebDriverConfig.getRemoteURL();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void afterTestMethod() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}