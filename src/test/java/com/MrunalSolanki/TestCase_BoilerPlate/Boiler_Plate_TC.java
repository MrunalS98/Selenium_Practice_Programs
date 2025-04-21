package com.MrunalSolanki.TestCase_BoilerPlate;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Boiler_Plate_TC {

    public FirefoxDriver driver;

    @BeforeTest
    public void open_browser(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.addArguments("start-maximized");

        driver = new FirefoxDriver(firefoxOptions);
    }

    @AfterTest
    public void close_browser(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver.quit();
    }
}
