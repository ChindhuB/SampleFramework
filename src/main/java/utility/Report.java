package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {
    public ExtentSparkReporter htmlReporter;
    public  ExtentReports extent;
    public ExtentTest extlogger;
    String repName;
    String timeStamp;

public Report(String browser){
    repName=browser.toUpperCase();
}
    public  ExtentReports createReport() {
        extent = new ExtentReports();
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        // specify name and location of the report
       repName = System.getProperty("user.dir") + "/test-output/" +repName+"_"+timeStamp+"_ExtentReport.html";
        htmlReporter = new ExtentSparkReporter(repName);
                //new ExtentSparkReporter("test-output/"+timeStamp+"_ExtentReport.html");
        extent.attachReporter( htmlReporter);

     try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        extent.setSystemInfo("Host name", "*.qa.*");
        extent.setSystemInfo("Environemnt", "QA");
        extent.setSystemInfo("user", "qaUser");
        extent.setReportUsesManualConfiguration(true);

        htmlReporter.config().setDocumentTitle("Sample Framework"); // Title of report
        htmlReporter.config().setReportName("Functional Test Report"); // name of the report
        htmlReporter.config().setTheme(Theme.STANDARD);
        return extent;

    }
        public void finishReport(ExtentReports extent) {
           extent.flush();
        }
}
