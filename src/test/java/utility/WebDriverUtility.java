package utility;
import config.FrameworkException;
import config.model.SeleniumTestParameters;
import org.openqa.selenium.WebDriver;


public class WebDriverUtility {
    public  static WebDriver driver = null;

    public static WebDriver browsersetUp(SeleniumTestParameters param) throws Exception {

        switch(param.getMode()){
            case LOCAL:
                driver=new WebDriverSetUp().getWebDriver(param.getBrowser());
                break;
            case GRID:
                driver=new WebDriverSetUp().getRemoteWebDriver(param.getMode(),param.getBrowser(),param.getPlatform());
                break;
            default:
                throw new FrameworkException("Driver Exception!");
        }

        return driver;
    }

}
