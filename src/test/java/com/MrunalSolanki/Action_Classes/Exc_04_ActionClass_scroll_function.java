package com.MrunalSolanki.Action_Classes;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Exc_04_ActionClass_scroll_function extends Boiler_Plate_TC {

    @Test
    @Description("Scrolling page up and Down")
    public void test_action_03(){

        String URL = "https://thetestingacademy.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_UP).build().perform();
    }
}
