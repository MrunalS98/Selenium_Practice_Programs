package com.MrunalSolanki.Relative_Locators;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RL_Prog_01 extends Boiler_Plate_TC {

    @Test
    public void test_to_the_right_element(){

        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement Exp_year_element = driver.findElement(By.xpath("//span[text()='Years of Experience']"));

        driver.findElement(with(By.id("exp-5")).toRightOf(Exp_year_element)).click();

        waitJVM(3000);
    }
}
