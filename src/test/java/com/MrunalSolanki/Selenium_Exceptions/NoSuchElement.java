package com.MrunalSolanki.Selenium_Exceptions;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class NoSuchElement extends Boiler_Plate_TC {

    @Test
    public void test_NoSuchElementException(){

        String URL = "https://app.vwo.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        try {
            driver.findElement(By.id("Mrunal"));
        } catch (NoSuchElementException e) {
            //e.printStackTrace();
            System.out.println("Element not found");
        }

        System.out.println("End of program");
    }
}
