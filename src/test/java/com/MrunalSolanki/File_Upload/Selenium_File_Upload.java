package com.MrunalSolanki.File_Upload;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Selenium_File_Upload extends Boiler_Plate_TC {

    @Test
    @Description("Upload file with selenium")
    public void test_file_upload(){

        String URL = "https://awesomeqa.com/selenium/upload.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement choose_file = driver.findElement(By.id("fileToUpload"));

        String working_dir = System.getProperty("user.dir");
        System.out.println(working_dir);

        choose_file.sendKeys(working_dir + "src/test/java/com/MrunalSolanki/File_Upload/TestData_Upload_File");
        driver.findElement(By.name("submit")).click();
    }
}
