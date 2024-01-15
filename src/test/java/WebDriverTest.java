import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.title;
import static org.junit.jupiter.api.Assertions.assertEquals;
import config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class WebDriverTest extends BaseTest{

//    private WebDriver driver;
//
//    @BeforeEach
//    public void startDriver(){
//        driver = new WebDriverProvider().get();
//    }

    @Test
    public void testGitHub(){
        open(baseUrl);
        webdriver().shouldHave(title("GitHub: Let’s build from here · GitHub"));
    }

//    @AfterEach
//    public void stopDriver(){
//        driver.quit();
//    }

}
