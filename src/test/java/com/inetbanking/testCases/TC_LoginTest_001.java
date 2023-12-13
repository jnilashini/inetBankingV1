package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {


        LoginPage lp = new LoginPage(driver);

        lp.setTxtUsername(uname);
        log.info("Entered Username");
        lp.setTxtPassword(password);
        log.info("Entered password");
        lp.clickSubmit();
        log.info("button clicked");

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
           Assert.assertTrue(true);
        }
        else
        {
            CaptureScreen(driver,"LoginTest");
            Assert.assertTrue(false);
        }

    }
}
