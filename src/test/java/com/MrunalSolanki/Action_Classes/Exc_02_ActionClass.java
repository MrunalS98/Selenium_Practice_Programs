package com.MrunalSolanki.Action_Classes;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import io.qameta.allure.Description;
import net.bytebuddy.implementation.bind.annotation.DefaultCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Exc_02_ActionClass extends Boiler_Plate_TC {

    @Test
    @Description("SpiceJet click and type city name")
    public void test_action_02(){

        String URL = "https://www.spicejet.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement from_city_name = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));

        Actions actions = new Actions(driver);

        actions
                .moveToElement(from_city_name)
                .click()
                .sendKeys("BOM")
                .build().perform();
    }
}
