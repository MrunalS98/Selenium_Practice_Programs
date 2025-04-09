package com.MrunalSolanki.SVG_Image_Handling;

import io.qameta.allure.Description;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;

public class SVG_MAP {
    FirefoxDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("---as a guest");
        firefoxOptions.addArguments("start-maximized");

        driver = new FirefoxDriver();
        driver.navigate().to("");
        System.out.println(driver.getTitle());
    }

    @Test
    @Description("Testing on SVG image with selenium")
    public void test_svg_icon_flipkart_search(){

        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);
        driver.manage().window().maximize();

        waitJVM(3000);

    }

    @AfterTest
    public void CloseBrowser(){
        waitJVM(10000);
        driver.quit();
    }
}
