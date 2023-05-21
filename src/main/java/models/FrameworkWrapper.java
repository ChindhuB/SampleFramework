/* Can design as model  / dto (Data Transfer Objective) package */
package models;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import utility.Report;

/**
 * Wrapper class for common framework objects, to be used across the entire test
 */
public class FrameworkWrapper {
    private final Report report;
    private WebDriver driver;
    public String repName;
    public FrameworkWrapper(Report report) {
        this.report = report;
    }

    public FrameworkWrapper(Report report, WebDriver driver) {
        this.report = report;
        this.driver = driver;
    }

    public WebDriver getwrapperDriver() {
        return driver;
    }

    public ExtentReports getwrapperExtentReport() {
        return report.createReport();

    }

    public Report getwrapperReport() {
        return report;

    }

}
