package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    // Constructor to complete the load file
    public ReadConfig() {
        File src = new File("./src/test/resources/Configuration/Config.properties");

        try {

            // reading values from config.properties file. we need to import FIS for reading values in read only mode
            // src is refering to config.properties file

            FileInputStream fis = new FileInputStream(src);
            pro = new Properties(); //by using properties obj we load all the variable values here

            pro.load(fis); // it will load complete config.properties file at run time
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }

    }

    public String getBaseURL() {
        //String URL = pro.getProperty("bsaeURL");
        //return URL;

        return pro.getProperty("baseURL");

    }

    public String getuname() {
        return pro.getProperty("uname");
    }

    public String getpassword() {

        return pro.getProperty("password");
    }
}
