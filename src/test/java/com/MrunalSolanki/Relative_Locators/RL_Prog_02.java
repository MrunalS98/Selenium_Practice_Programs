package com.MrunalSolanki.Relative_Locators;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class RL_Prog_02 extends Boiler_Plate_TC {

    @Test
    public void test_Below_element(){

        String URL = "https://codepen.io/AbdullahSajjad/full/LYGVRgK";
        driver.get(URL);
        driver.manage().window().maximize();

        // iframe
        driver.switchTo().frame("result");

        WebElement submit_button_click = driver.findElement(By.xpath("//button[text()='Submit']"));
        submit_button_click.click();

        WebElement username_field = driver.findElement(By.id("username"));

        //WebElement error_element = driver.findElement(with(By.tagName("small")).below(username_element));

        WebElement Error_Msg = driver.findElement(with(By.xpath("//small[text()='Username must be at least 3 characters']")).below(username_field));

        //check if the is correct msf or not with
        String errorText = Error_Msg.getText();
        Assert.assertEquals(errorText,"Username must be at least 3 characters");

    }
}
