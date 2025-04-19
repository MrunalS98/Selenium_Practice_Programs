package com.MrunalSolanki.SVG_Image_Handling;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;

public class SVG_MAP {
    FirefoxDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("---as a guest");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Description("Testing on SVG image with selenium for MAP")
    public void test_svg_icon_flipkart_search(){

        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);
        driver.manage().window().maximize();

        waitJVM(3000);
        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for (WebElement state: states) {
            System.out.println(state.getDomAttribute("aria-label"));
            if (state.getDomAttribute("aria-label").contains("Maharashtra  ")) {
                state.click();
            }
        }
    }

    @AfterTest
    public void CloseBrowser(){
        waitJVM(10000);
        driver.quit();
    }
}
