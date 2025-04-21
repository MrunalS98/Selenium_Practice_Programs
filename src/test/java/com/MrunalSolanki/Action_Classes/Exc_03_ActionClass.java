package com.MrunalSolanki.Action_Classes;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;

public class Exc_03_ActionClass extends Boiler_Plate_TC {

    @Test
    @Description("MakeMyTrip close model, Click on from, enter city shortcut and select city from dropdown")
    public void test_action_03() {

        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        TestSelenium_WaitHelpers.checkVisibility(driver, By.xpath("//span[@data-cy='closeModal']"));
        WebElement colsemodel = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        colsemodel.click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("IXC").build().perform();

        waitJVM(3000);

        List<WebElement> list_autocomplete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

        for (WebElement e : list_autocomplete) {

            if (e.getText().contains("Chandigarh")) {
                e.click();
            }


        }
    }
}
