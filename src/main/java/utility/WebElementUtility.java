package utility;

import models.FrameworkWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebElementUtility extends PageDriver {


    public WebElementUtility(FrameworkWrapper wrapper) {
        super(wrapper);
    }

    public boolean isElementVisible(By arg0) {
        boolean elementVisible = false;
        try {
            (new WebDriverWait(getWebDriver(), Duration.ofSeconds(30))).until(ExpectedConditions.visibilityOfElementLocated(arg0));
            elementVisible = true;

        } catch (TimeoutException ex) {
            elementVisible = false;
        }
        return elementVisible;
    }

    public List<WebElement> findElements(By arg0) {
        return getWebDriver().findElements(arg0);
    }

    public WebElement findElement(By arg0) {
        return getWebDriver().findElement(arg0);
    }

    /**
     * Function to Get a string representing the current URL that the browser is
     * looking at. {@link WebDriver}
     */
    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    /**
     * Function to Get the source of the last loaded page. {@link WebDriver}
     */
    public String getPageSource() {
        return getWebDriver().getPageSource();
    }

    /**
     * Function to get The title of the current page. {@link WebDriver}
     */
    public String getTitle() {
        return getWebDriver().getTitle();
    }

    /**
     * Function to Return an opaque handle to this window that uniquely identifies
     * it within this driver instance {@link WebDriver}
     */
    public String getWindowHandle() {
        return getWebDriver().getWindowHandle();
    }

    /**
     * Function to Return a set of window handles which can be used to iterate over
     * all open windows of this WebDriver instance by passing them to
     * {@link WebDriver}
     */
    public Set<String> getWindowHandles() {
        return getWebDriver().getWindowHandles();
    }

    /**
     * Function to Load a new web page in the current browser window.
     * {@link WebDriver}
     */
    public void get(String arg0) {
        getWebDriver().get(arg0);
    }

    /**
     * Function to Gets the Option interface. {@link WebDriver}
     */
    public WebDriver.Options manage() {
        return getWebDriver().manage();
    }

    /**
     * Function to GetAn abstraction allowing the driver to access the browser's
     * history and to navigate to a given URL. {@link WebDriver}
     */
    public WebDriver.Navigation navigate() {
        return getWebDriver().navigate();
    }


    /**
     * Function to Send future commands to a different frame or window.
     * {@link WebDriver}
     */
    public WebDriver.TargetLocator switchTo() {
        return getWebDriver().switchTo();
    }

    public void driverwait() {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(60));
    }

    public void pageLoadwait() {
        try{
            Thread.sleep(500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       /* ExpectedCondition<Boolean> pageReadyStateComplete =
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) getWebDriver()).executeScript("return document.readyState").equals("complete");
                    }
                };

       // boolean b=((JavascriptExecutor) getWebDriver()).executeScript("return document.readyState").equals("complete");
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(60)).until(pageReadyStateComplete);
*/
    }
    public void selectText(By arg0,String text){
        new Select(getWebDriver().findElement(arg0)).selectByVisibleText(text);
    }
    public void mouseOver(By arg) {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(getWebDriver().findElement(arg)).build().perform();
    }

}

