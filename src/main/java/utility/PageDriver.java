package utility;

import models.FrameworkWrapper;
import org.openqa.selenium.WebDriver;

public class PageDriver {
private FrameworkWrapper wrapper;

    private WebDriver driver;
    public PageDriver(FrameworkWrapper wrapper){

        this.wrapper=wrapper;
        this.driver=wrapper.getwrapperDriver();

    }
    public WebDriver getWebDriver() {
        return (WebDriver) driver;
    }
    public FrameworkWrapper getWrapper(){
        return wrapper;
    }
}
