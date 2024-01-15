package config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverConfigOld {
    public String getBaseUrl(){
        String baseUrl = System.getProperty("baseUrl");
        if (Objects.isNull(baseUrl)){
            baseUrl = "https://github.com";
        }
        return baseUrl;
    }

    public Browser getBrowser(){
        String browser = System.getProperty("browser");
        if (Objects.isNull(browser)){
            browser = "CHROME";
        }
        return Browser.valueOf(browser);
    }

    public URL getRemoteUrl(){
        String remoteURL = System.getProperty("remoteURL");
        if (Objects.isNull(remoteURL)){
            remoteURL = "http://localhost:4444";
        }
        try {
            return new URL(remoteURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
