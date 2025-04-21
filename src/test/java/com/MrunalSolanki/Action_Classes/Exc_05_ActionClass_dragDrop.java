package com.MrunalSolanki.Action_Classes;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Exc_05_ActionClass_dragDrop extends Boiler_Plate_TC {

    @Test
    @Description("Drage and Drop functionality")
    public void test_action_05(){

        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement box_a = driver.findElement(By.id("column-a"));
        WebElement box_b = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(box_a,box_b).build().perform();
    }
}
