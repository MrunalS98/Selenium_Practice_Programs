package com.MrunalSolanki.Alert_In_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_alert {

    @Test
    @Description("Verify alerts in selenium")
    public  void alert_model_test() {

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");

        FirefoxDriver driver = new FirefoxDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());


      /*  WebElement element = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        element.click();*/
/*

        WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        elementConfirm.click();
*/

        WebElement elementPrompt= driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        elementPrompt.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        //alert.accept();
        alert.sendKeys("Mrunal");
        alert.accept();
        String result = driver.findElement(By.id("result")).getText();
        // Assert.assertEquals(result,"You successfully clicked an alert");

        //   Assert.assertEquals(result,"You clicked: Ok");
//        Assert.assertEquals(result,"You clicked: Cancel");
        Assert.assertEquals(result,"You entered: Mrunal");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
