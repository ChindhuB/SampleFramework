package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.support.descriptor.ClassSource;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import testscripts.contracttests.BaseServiceTest;
import testscripts.uitests.TestBase;
import utility.Report;


public class CustomListener extends TestBase implements TestExecutionListener {
    Description d;
    Report report;
    static ExtentTest logger;

    public Description toDescription(TestIdentifier i) {

        d = new Description(i.getDisplayName());
        TestSource ts = i.getSource().orElse(null);

        if (ts instanceof MethodSource m) {
            d.setClassName(m.getJavaClass());
            d.setMethodName(m.getMethodName());
        } else if (ts instanceof ClassSource c) {
            d.setClassName(c.getJavaClass());
        } else if (ts != null) {
            throw new IllegalArgumentException("Unrecognized source");
        }
        return d;
    }

    public String shorterStacktrace(Throwable ex) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ex.printStackTrace(new PrintStream(os));
        return os.toString(StandardCharsets.UTF_8).lines().limit(6).collect(Collectors.joining("\n")) + "\n\t...";
    }

    @Override
    public void executionStarted(TestIdentifier i) {
        if (TestBase.URL != null) {
            logger = TestBase.logger;
            d = toDescription(i);
        } else {
            d = toDescription(i);
        }

        if (d.getMethodName() != null) { // skip class
            log(">" + d);
        }
        if (TestBase.URL != null) {
            TestBase.d = d;
        } else {
            BaseServiceTest.d = d;
            extent = BaseServiceTest.extent;
            if (extent != null) {
                if (BaseServiceTest.init == 0) {
                    createLog(extent);
                    lognode = logger.createNode(d.getDisplayName(), d.getClassName() + ":" + d.getMethodName());
                  lognode.getModel().setStatus(Status.INFO);
                    setStartTime(logger);
                    setStartTime(lognode);
                    BaseServiceTest.init = 1;
                    BaseServiceTest.logger = logger;
                    BaseServiceTest.lognode = lognode;

                } else {
                    lognode = logger.createNode(d.getDisplayName(), d.getClassName() + ":" + d.getMethodName());
                    lognode.getModel().setStatus(Status.INFO);
                    setStartTime(lognode);
                    BaseServiceTest.lognode = lognode;
                }
            }
        }
    }

    @Override
    public void executionFinished(TestIdentifier i, TestExecutionResult r) {
        if (TestBase.URL != null) {
            logger = TestBase.logger;
        }
        d = toDescription(i);
        if (d.getMethodName() != null) { // skip class names
            if (r.getThrowable().isPresent()) {
                log(shorterStacktrace(r.getThrowable().get()));
            }
            log("<" + d + "\n");

            if (r.getStatus() == TestExecutionResult.Status.SUCCESSFUL) {
                if (TestBase.URL != null) {
                    logger.log(Status.PASS, MarkupHelper.createLabel(d.methodName + " Test Case PASSED", ExtentColor.GREEN));
                } else {
                    if ( d.getDisplayName().toString().replace("[","").matches("\\d+.*")) {
                        lognode.log(Status.PASS, MarkupHelper.createLabel(d.getDisplayName().toString() + ":" + d.methodName + " Test Case PASSED", ExtentColor.GREEN));
                    }
                }
            } else if (r.getStatus() == TestExecutionResult.Status.FAILED) {
                if (TestBase.URL != null) {
                    logger.log(Status.FAIL, MarkupHelper.createLabel(d.methodName + " Test Case Failed", ExtentColor.RED));
                    logger.log(Status.FAIL, r.getThrowable().get());
                } else {
                    if (d.getDisplayName().toString().replace("[","").matches("\\d+.*")) {
                        lognode.log(Status.FAIL, MarkupHelper.createLabel(d.getDisplayName().toString() + ":" + d.methodName + " Test Case Failed", ExtentColor.RED));
                        lognode.log(Status.FAIL, r.getThrowable().get());
                    }
                }

            } else {
                if (TestBase.URL != null) {
                    logger.log(Status.SKIP, MarkupHelper.createLabel(d.methodName + " Test Case Skipped", ExtentColor.ORANGE));
                } else {
                    if (i.getDisplayName().replace("[","").matches("\\d+.*")) {
                        lognode.log(Status.SKIP, MarkupHelper.createLabel(d.getDisplayName().toString() + ":" + d.methodName + " Test Case Skipped", ExtentColor.ORANGE));
                    }
                }
            }
            if (TestBase.URL != null) {
                setEndTime(logger);
            } else {
                setEndTime(lognode);
            }
        }

    }

    void log(String message) {
        System.out.println("*** " + message);
    }


    public static void setStartTime(ExtentTest logger) {
        logger.getModel().setStartTime(getTime(System.currentTimeMillis()));
    }

    public static void setEndTime(ExtentTest logger) {
        logger.getModel().setEndTime(getTime(System.currentTimeMillis()));
    }

    private static Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public void createLog(ExtentReports extent) {
        if (d.getClassName() != null) {
            logger = extent.createTest(d.getClassName());
            setStartTime(logger);
        }
    }


}
