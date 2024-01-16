import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.title;

public class WebDriverTest extends BaseTest{

    @Test
    public void testGitHubLocal(){
        open(baseUrl);
        webdriver().shouldHave(title("GitHub: Let’s build from here · GitHub"));
    }
}
