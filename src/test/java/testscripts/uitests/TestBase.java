package testscripts.uitests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;;
import config.Browser;
import config.ExecutionMode;
import config.model.SeleniumTestParameters;
import listener.CustomListener;
import listener.Description;
import models.FrameworkWrapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import utility.Report;
import utility.WebDriverSetUp;
import utility.WebDriverUtility;


public class TestBase {

    public static String URL;
    public static Report report;
    public static FrameworkWrapper wrapper;
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static Description d;
    protected ExtentTest lognode;


    @BeforeAll
    public static void setUp() throws Exception {
        SeleniumTestParameters param = new SeleniumTestParameters(ExecutionMode.GRID, Browser.CHROME, "windows");
        URL = WebDriverSetUp.getProperties().getProperty("url");
        driver = WebDriverUtility.browsersetUp(param);
        report = new Report(String.valueOf(param.getBrowser()));
        wrapper = new FrameworkWrapper(report, driver);
        extent = wrapper.getwrapperExtentReport();
        logger = wrapper.getwrapperReport().extlogger;
        driver.get(URL);
        driver.manage().window().maximize();
    }

    /*@BeforeEach
    public void getURL() {
        driver.navigate().to(URL);
    }
*/

    @AfterAll
    public static void tearDown() {
        report.finishReport(extent);
        driver.quit();
        System.out.println("The driver has been closed.");
    }

    public void createLog() {
        logger = extent.createTest(d.getDisplayName(), d.getClassName() + ":" + d.getMethodName());
        CustomListener.setStartTime(logger);
    }

    public void setNodeStartTime(ExtentTest loggerNode) {
        CustomListener.setEndTime(loggerNode);
    }

    public void setNodeEndTime(ExtentTest loggerNode) {
        CustomListener.setEndTime(loggerNode);
    }

}