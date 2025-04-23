package com.MrunalSolanki.Windows_Handle;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;

public class window_part_02 extends Boiler_Plate_TC {

    @Test
    @Description("Windows in selenium for multiple windows")
    public void test_window_multiple(){
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();
        waitJVM(5000);

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent -> " + parentWindowHandle);

        List<WebElement> list_heatmaps = driver.findElements(By.cssSelector("[data-qa=\"yedexafobi\"]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(list_heatmaps.get(1)).click().build().perform();

        waitJVM(15000);

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All Window Handles: " + allHandles);

        for (String handle: allHandles) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                // Now I am in the child window
                driver.switchTo().frame("heatmap-iframe");

                WebElement clickmap = driver.findElement(By.cssSelector("[data-qa='liqokuxuba']"));
                clickmap.click();
            }
        }
    }
}
