package com.MrunalSolanki.Katalon_Full_Flow;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Katalon_Demo {

    @Test
    @Description("Verify full login-logout flow for katalon site")
    public void test_katalon_site_flow(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");

        FirefoxDriver driver = new FirefoxDriver();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-make-appointment")));

        WebElement closeModel = driver.findElement(By.id("btn-make-appointment"));
        closeModel.click();

        //Login Flow
        WebElement usernameinputbox = driver.findElement(By.id("txt-username"));
        usernameinputbox.sendKeys("John Doe");
        WebElement passwordinputbox = driver.findElement(By.id("txt-password"));
        passwordinputbox.sendKeys("ThisIsNotAPassword");
        WebElement loginbutton = driver.findElement(By.id("btn-login"));
        loginbutton.click();

        //Form Fill Flow
        WebElement element_select = driver.findElement(By.id("combo_facility"));
        Select select = new Select(element_select);
        select.selectByValue("Seoul CURA Healthcare Center");

        driver.findElement(By.id("chk_hospotal_readmission")).click();

        driver.findElement(By.id("radio_program_none")).click();

        WebElement visitDate=driver.findElement(By.cssSelector("input[placeholder='dd/mm/yyyy']"));
        visitDate.sendKeys("04/04/2025");

        WebElement comment_Box=driver.findElement(By.id("txt_comment"));
        comment_Box.sendKeys("I am booking");

        driver.findElement(By.id("btn-book-appointment")).click();

        //Verify the comment
        WebElement commentTxt=driver.findElement(By.xpath("//div[@class='col-xs-8' ]/p [@id='comment']"));
        String Text=commentTxt.getText();
        System.out.println(Text);
        if(Text.contains("I am booking")){
            System.out.println("Validated comments for appointment");
        }

        //logout
        driver.findElement(By.id("menu-toggle")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();


        driver.quit();
    }
}
