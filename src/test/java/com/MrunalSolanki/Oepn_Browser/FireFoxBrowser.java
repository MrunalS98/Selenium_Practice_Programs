package com.MrunalSolanki.Oepn_Browser;

import io.qameta.allure.Description;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FireFoxBrowser {

        @Test
        @Description("Verify Browse is getting open with given link")
        public void test_verify_browser(){
            FirefoxDriver driver = new FirefoxDriver();
            driver.get("https://app.vwo.com");
            System.out.println(driver.getTitle());
        }
    }