package com.MrunalSolanki.Selenium_Exceptions;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElementReferenceExceptionHandling extends Boiler_Plate_TC {

    @Test
    public void test_StaleElementReferenceException(){

        String URL = "https://google.com";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement input_search_box = driver.findElement(By.id("APjFqb"));

        System.out.println(driver.getWindowHandle());

        driver.navigate().refresh();
        // When REACT application(SPA), they change the DOM structure) That is not in your hand.


        // HTML Page (DOM) is refreshed NOW,
        // Driver will think that, element may or may not available now.
        // I have found the element before refresh.

        // Refresh, Navigate other Page, change in DOM elements (Ajax Calls) - VueJS, AngularJS

        // If you want to fix the stale element exp - refind the element after DOM changes)
        //search_inputbox  = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));

        try {
            input_search_box.sendKeys("Chat GPT"+ Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println("testing StaleElementReferenceException");

            WebElement search_input_box1  = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            search_input_box1.sendKeys("Chat GPT"+Keys.ENTER);
        }
        // org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found
        System.out.println(driver.getWindowHandle());
        System.out.println("End of program");

    }
}
