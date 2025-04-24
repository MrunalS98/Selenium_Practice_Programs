package com.MrunalSolanki.Selenium_Exceptions;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.StaleElementReferenceException;

public class StaleElementReference extends Boiler_Plate_TC {

    @Test
    public void test_StaleElementReferenceException(){

        String URL = "https://google.com";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement input_search_box = driver.findElement(By.id("APjFqb"));
        input_search_box.sendKeys("chat GPT" + Keys.ENTER);

        driver.navigate().refresh();

        try {
            input_search_box.sendKeys("chat GPT" + Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is Stale Due to page refresh");
        }

    }
}
