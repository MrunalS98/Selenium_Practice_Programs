package com.MrunalSolanki.SVG_Image_Handling;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.checkVisibility;
import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;

import java.util.List;

public class SVG_With_Selenium {

    FirefoxDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("---as a guest");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Description("Testing on SVG image with selenium for Flipkart")
    public void test_svg_icon_flipkart_search(){

        String URL = "https://www.flipkart.com/search";
        driver.get(URL);

        // Step 1 - Enter the "macnmini" in the inputbox.
        driver.findElement(By.name("q")).sendKeys("macmini");

        // Step 2 - Click on the svg element.
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

        checkVisibility(driver,By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));


        List<WebElement> titlesResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for (WebElement title :  titlesResults){
            System.out.println(title.getText());
        }
    }

    @AfterTest
    public void CloseBrowser(){
        waitJVM(10000);
        driver.quit();
    }
}
