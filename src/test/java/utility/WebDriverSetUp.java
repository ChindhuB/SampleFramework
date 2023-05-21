package utility;

import config.Browser;
import config.ConfigSettings;
import config.ExecutionMode;
import config.FrameworkException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class WebDriverSetUp implements WebDriverInit {
   private  static WebDriver driver;
   private static DesiredCapabilities capability=new DesiredCapabilities();
   public static Properties getProperties(){
       return  ConfigSettings.getInstance();
   }

    public  WebDriver getWebDriver(Browser browser){

        switch (browser) {
            case CHROME:
                // Takes the system proxy settings automatically
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case CHROME_HEADLESS:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:
                // Takes the system proxy settings automatically
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case INTERNET_EXPLORER:
                // Takes the system proxy settings automatically

                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            case EDGE:
                // Takes the system proxy settings automatically

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new FrameworkException("Unhandled browser or driver!");
        }
    return driver;
    }
    public  WebDriver getRemoteWebDriver(ExecutionMode mode, Browser browser, String platform){

        switch(platform) {
            case "windows":
                capability.setPlatform(Platform.WINDOWS);
            default:
                 new FrameworkException("Unhandled Platform!");
                 break;
        }

        switch (browser) {
            case CHROME:
                capability.setBrowserName("chrome");
                break;
            case FIREFOX:
                capability.setBrowserName("firefox");
                break;
            case CHROME_HEADLESS:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                capability.setBrowserName("chrome");
                capability.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
                break;
            case EDGE:
                capability.setBrowserName("MicrosoftEdge");
                break;
            default:
                throw new FrameworkException("Unhandled browser!");
        }


        try {
                    driver = new RemoteWebDriver(new URL(getProperties().getProperty("remoteUrl")), capability);

            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
            return driver;
    }
}
