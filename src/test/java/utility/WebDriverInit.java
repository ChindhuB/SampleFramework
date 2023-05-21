package utility;

import config.Browser;
import config.ExecutionMode;
import org.openqa.selenium.WebDriver;

public interface WebDriverInit {

    public  WebDriver getWebDriver(Browser browser);
    public  WebDriver getRemoteWebDriver(ExecutionMode mode, Browser browser, String platform);

}
