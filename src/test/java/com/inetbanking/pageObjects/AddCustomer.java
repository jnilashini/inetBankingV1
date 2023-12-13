package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

    WebDriver ldriver;

    public AddCustomer(WebDriver rdriver)
    {
        ldriver = rdriver;

        PageFactory.initElements(rdriver,this);

    }

    @FindBy(how = How.LINK_TEXT, using="New Customer")
    WebElement lnkNewCustomer;

    @FindBy(how = How.NAME, using="name")
    WebElement txtCustName;

    @FindBy(how = How.CSS, using="input[value='m']")
    WebElement rbGender;

    @FindBy(how = How.NAME, using="dob")
    WebElement txtDOB;

    @FindBy(how = How.NAME, using="addr")
    WebElement txtaddr;

    @FindBy(how = How.NAME, using="city")
    WebElement txtcity;

    @FindBy(how = How.NAME, using="state")
    WebElement txtstate;

    @FindBy(how = How.NAME, using="pinno")
    WebElement txtpinno;

    @FindBy(name="telephoneno")
    WebElement txttelephoneno;

    @FindBy(how = How.NAME, using="emailid")
    WebElement txtemailid;

    @FindBy(how = How.NAME, using="password")
    WebElement txtpassword;

    @FindBy(how = How.NAME, using="sub")
    WebElement btnSubmit;



    public void linkClick()
    {
        lnkNewCustomer.click();
    }

    public void setCustName(String custName)
    {
        txtCustName.sendKeys(custName);
    }

    public void setGender(String gender)
    {
        rbGender.click();
    }

    public void setDOB(String mm, String dd,String yy)
    {
        txtDOB.sendKeys(mm);
        txtDOB.sendKeys(dd);
        txtDOB.sendKeys(yy);
    }

    public void setAddr(String addr)
    {
        txtaddr.sendKeys(addr);
    }

    public void setcity(String city)
    {
        txtcity.sendKeys(city);
    }

    public void setState(String state)
    {
        txtstate.sendKeys(state);
    }

    public void setpin(String pin)
    {
        txtpinno.sendKeys(pin);
    }

    public void setPhone(String phone)
    {
        txttelephoneno.sendKeys(phone);
    }

    public void setEmailid(String emailid)
    {
        txtemailid.sendKeys(emailid);
    }
    public void setPassword(String password)
    {
        txtpassword.sendKeys(password);
    }

    public void btnClick()
    {
        btnSubmit.click();
    }


}
