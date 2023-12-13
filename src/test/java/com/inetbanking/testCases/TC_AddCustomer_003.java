package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddCustomer;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomer_003 extends BaseClass {

    @Test
    public void addCustomer() throws IOException {

        LoginPage lp = new LoginPage(driver);
        lp.setTxtUsername(uname);
        lp.setTxtPassword(password);
        lp.clickSubmit();

        AddCustomer addCustomer = new AddCustomer(driver);
        addCustomer.linkClick();
        addCustomer.setCustName("Nila");
        addCustomer.setGender("female");
        addCustomer.setDOB("07", "07", "85");
        addCustomer.setAddr("coventry court");
        addCustomer.setcity("Columbus");
        addCustomer.setState("OH");

        addCustomer.setpin("123456");
        addCustomer.setPhone("1234567890");
        String ranEmail = randomString() + "@gmail.com";
        addCustomer.setEmailid(ranEmail);
        addCustomer.setPassword("nila");

        addCustomer.btnClick();

        boolean bmessage = driver.getPageSource().contains("Customer Registered Successfully!!!");

        if (bmessage == true) {
            Assert.assertTrue(true);
            log.info("success");
        } else {
            CaptureScreen(driver, "AddCustomerPage");
            Assert.assertTrue(false);
            log.info("Fail");
        }


    }


}


