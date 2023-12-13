package com.inetbanking.utilities;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

// its a Listener Uttility Class used to generate Extent REports
public class Reporting extends TestListenerAdapter {

    public ExtentReports extentReports;
    public static ExtentTest testLogger;
    public ExtentSparkReporter sparkReports;


    public void onStart(ITestContext iTestContext) {
        String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String repName = "Test-Report" + timeStamp + ".html";
        sparkReports = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);

        try {
            sparkReports.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sparkReports.config().setDocumentTitle("Testing - Live Project");
        sparkReports.config().setReportName("Functional Test Report");
        sparkReports.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReports);
        extentReports.setSystemInfo("Host Name", "localhost");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("user", "Nila");

    }

    public void onTestFailure(ITestResult testResult) {
        testLogger = extentReports.createTest(testResult.getName());
        testLogger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));
      //  CaptureScreen();

        String screenshots = "./Screenshots/" + testResult.getName() + ".png";

        File f = new File(screenshots);

        if (f.exists()) {

            testLogger.fail("Screenshot is below" + testLogger.addScreenCaptureFromPath(screenshots));

        }
    }

    public void onTestSuccess(ITestResult testResult) {

        testLogger = extentReports.createTest(testResult.getName());
        testLogger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));


    }

    public void onTestSkipped(ITestResult iTestResult) {
        testLogger = extentReports.createTest(iTestResult.getName());
        testLogger.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.ORANGE));

    }

    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }
}
