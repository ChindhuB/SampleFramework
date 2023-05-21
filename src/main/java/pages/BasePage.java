package pages;

import models.FrameworkWrapper;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.PageDriver;
import utility.WebElementUtility;

import java.util.Optional;

public class BasePage extends PageDriver {
    protected WebElementUtility elemUtil;
    protected Optional<String> title;
    protected final Logger log= LoggerFactory.getLogger(getClass());

    protected BasePage(FrameworkWrapper wrapper){

            super(wrapper);
            PageFactory.initElements(getWebDriver(), this);
            elemUtil = new WebElementUtility(wrapper);
            title = Optional.ofNullable(elemUtil.getTitle());
    }
}
