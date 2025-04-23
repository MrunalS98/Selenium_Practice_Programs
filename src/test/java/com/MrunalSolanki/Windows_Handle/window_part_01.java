package com.MrunalSolanki.Windows_Handle;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;

public class window_part_01 extends Boiler_Plate_TC {

    @Test
            public void test_single_window(){

    String URL = "https://the-internet.herokuapp.com/windows";
    driver.get(URL);
    driver.manage().window().maximize();

        String parent = driver.getWindowHandle();
        System.out.println(parent);

        driver.findElement(By.linkText("Click Here")).click();

        waitJVM(3000);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Window Handles: " + windowHandles); // [974535CFD9B87DA0B44B44CC2FFC0591, 8E6F9A52E8382019CBB64FB9E6F024EC]

        waitJVM(3000);
        for (String handle: windowHandles){
            driver.switchTo().window(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed!");
            }
            //switch to parent window again
            driver.switchTo().window(parent);
        }
    }
}
