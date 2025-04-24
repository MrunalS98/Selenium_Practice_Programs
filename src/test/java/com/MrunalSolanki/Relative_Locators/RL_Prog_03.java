package com.MrunalSolanki.Relative_Locators;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.security.Key;
import java.util.List;

public class RL_Prog_03 extends Boiler_Plate_TC {

    @Test
    public void test_print_table_data_with_RL(){

        String URL = "https://www.aqi.in/real-time-most-polluted-city-ranking";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement search_input_box = driver.findElement(By.xpath("//input[@type='search' and @placeholder='Search']"));
        search_input_box.sendKeys("India" + Keys.ENTER);

        waitJVM(5000);

        List<WebElement> locations = driver.findElements(By.cssSelector("div.location-name > p"));
        for (WebElement location : locations) {

            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(location)).getText();
            String aqi = driver.findElement(with(By.tagName("span")).toRightOf(location)).getText();
            System.out.println("| +" + rank + " | " + location.getText() + " | " + aqi + " | ");

            //https://www.selenium.dev/documentation/webdriver/elements/locators/
            //More information on RL
        }
        }
}
