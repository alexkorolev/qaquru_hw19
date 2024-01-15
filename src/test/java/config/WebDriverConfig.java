package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
        "classpath:remote.properties",
         "classpath:local.properties"

})
public interface WebDriverConfig extends Config
{
    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser.name")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browser.version")
    @DefaultValue("114")
    String browserVersion();

    @Key("load.stratagy")
    @DefaultValue("eager")
    String loadStrategy();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("start.selenoid")
    @DefaultValue("false")
    String remoteLoad();

    @Key("remote.url")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemoteURL();

}
