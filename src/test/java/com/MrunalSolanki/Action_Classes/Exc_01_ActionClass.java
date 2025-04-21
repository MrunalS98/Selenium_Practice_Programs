package com.MrunalSolanki.Action_Classes;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class Exc_01_ActionClass extends Boiler_Plate_TC {

    @Test
    public void test_action_01(){

        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();


        WebElement firstname_input_box = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);           //give the driver to it
        //Press shift kry and type the name
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(firstname_input_box, "Mrunal")
                .keyUp(Keys.SHIFT)
                .build().perform();
    }
}
