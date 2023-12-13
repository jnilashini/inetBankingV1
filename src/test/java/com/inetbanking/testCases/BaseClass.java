package com.inetbanking.testCases;


import com.aventstack.extentreports.ExtentTest;
import com.inetbanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class BaseClass {

    ReadConfig rConfig = new ReadConfig(); //Read Values form Readconfig class from Utility package

    public String baseURL = rConfig.getBaseURL();
    public String uname = rConfig.getuname();
    public String password = rConfig.getpassword();
    public static WebDriver driver;
    public static Logger log;


    @Parameters("browser")
    @BeforeClass
    public void Setup(String getbrowser) {


        switch (getbrowser) {
            case "Chrome":
//                ChromeOptions chroptions = new ChromeOptions();
//                chroptions.addArguments("start-maximized");
                driver = new ChromeDriver();
                break;
            case "Safari":
                driver = new SafariDriver();

                break;
            case "Firefox":
                driver = new FirefoxDriver();

                break;
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        log = Logger.getLogger("eBanking");
        // log.config("Log4j.properties");
        log.info("Setup completed");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);

    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }

    public void CaptureScreen(WebDriver driver, String tName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("./Screenshots/" + tName + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot Taken");
    }

    public String randomString()
    {
        String randomString= RandomStringUtils.randomAlphabetic(8);
        return randomString;
    }
}
