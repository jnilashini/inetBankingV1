package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(name="uid")
    WebElement txtUsername;

    @FindBy(name="password")
    WebElement txtPassword;

    @FindBy(name="btnLogin")
    WebElement btnlogin;

    @FindBy(name="btnReset")
    WebElement btnReset;

    @FindBy(css = "a[href='Logout.php']")
    WebElement hrfLogout;

    public void setTxtUsername(String uName)
    {
        txtUsername.sendKeys(uName);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickSubmit()
    {
btnlogin.click();
    }

    public void clickReset()
    {
btnReset.click();
    }

    public void btnLogout()
    {
        hrfLogout.click();
    }

}
