package com.MrunalSolanki.Selenium_Exceptions;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;

public class TimeOutExceptionHandling extends Boiler_Plate_TC {

    @Test
    public void test_time_Out_Exception(){

        String URL = "https://google.com";
        driver.get(URL);
        driver.manage().window().maximize();

        //If you are waiting for an element which is not found
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='abc']")));

            WebElement input_search_box = driver.findElement(By.id("APjFqb"));
            input_search_box.sendKeys("Chat GPT" + Keys.ENTER);
        } catch (TimeoutException e) {
            System.out.println("Testing TimeOut Exception handling");
        }

    }
}
