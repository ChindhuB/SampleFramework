package testscripts.contracttests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import config.ConfigSettings;
import listener.CustomListener;
import listener.Description;
import models.FrameworkWrapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import services.AuthService;
import utility.Report;

import java.util.Properties;

public class BaseServiceTest {
    static String accessToken;
    public static Report report;
    public static FrameworkWrapper wrapper;
    public static ExtentReports extent;
    public static ExtentTest logger,lognode;
    public static Description d;
    public static int init;

    @BeforeAll
    public static void setup() {
        Properties prop = ConfigSettings.getInstance();
        AuthService auth = new AuthService();
        accessToken = auth.getToken(prop.getProperty("apiUsername"), prop.getProperty("apiPassword"));
        report = new Report("API");
        wrapper = new FrameworkWrapper(report);
        extent = wrapper.getwrapperExtentReport();
        logger = wrapper.getwrapperReport().extlogger;
        init = 0;

    }

     @AfterAll
    public static void tearDown() {
        CustomListener.setEndTime(logger);
        report.finishReport(extent);

    }


    public void setNodeStartTime(ExtentTest loggerNode) {
        CustomListener.setStartTime(loggerNode);
    }

    public void setNodeEndTime(ExtentTest loggerNode) {
        CustomListener.setEndTime(loggerNode);
    }

}
