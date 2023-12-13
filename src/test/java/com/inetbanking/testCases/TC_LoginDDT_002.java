package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void LoginDDT(String uname, String password) throws IOException {

        LoginPage lp = new LoginPage(driver);
        lp.setTxtUsername(uname);
        log.info("username provided");
        lp.setTxtPassword(password);
        log.info("password provided");
        lp.clickSubmit();
        log.info("login button clicked");

        if (isAlertPresent() == true) {
            CaptureScreen(driver, "LoginDDT");
            log.info("login failed");
            driver.switchTo().alert().accept(); //close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            log.warning("login failed");
        } else {
            Assert.assertTrue(true);
            log.info("login passed");
            lp.btnLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();


        }

    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @DataProvider(name = "LoginData")
    String[][] getData() throws IOException {
        String xlPath = "./src/test/java/com/inetbanking/testData/TestFileForLiveProject.xlsx";

        int rowNum = XLUtil.getRowCount(xlPath, "Sheet1");
        int colNum = XLUtil.getCellCount(xlPath, "Sheet1", rowNum);

        String loginData[][] = new String[rowNum][colNum];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                loginData[i - 1][j] = XLUtil.getCellData(xlPath, "Sheet1", i, j);

            }
        }

        return loginData;
    }
}
