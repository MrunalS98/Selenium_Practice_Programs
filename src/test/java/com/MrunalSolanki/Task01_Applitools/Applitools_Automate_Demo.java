package com.MrunalSolanki.Task01_Applitools;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Applitools_Automate_Demo {

    @Test
    @Description("Verify Applitools Automation Flow")
    public void test_applitools_flow(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");

        FirefoxDriver driver = new FirefoxDriver();
        driver.navigate().to("https://demo.applitools.com/");
        System.out.println(driver.getTitle());

        WebElement username_input_box = driver.findElement(By.id("username"));
        username_input_box.sendKeys("Admin");

        WebElement password_input_box = driver.findElement(By.id("username"));
        password_input_box.sendKeys("Password@123");

        WebElement click_on_login_button = driver.findElement(By.id("log-in"));
        click_on_login_button.click();

        double totalAmount = 0;

        // Locate all amount elements from the last column
        List<WebElement> amountElements = driver.findElements(By.xpath("//table//tr/td[last()]"));

        for (WebElement element : amountElements) {
            String amountText = element.getText().replace("USD", "").trim();

            // Remove commas and convert to double
            amountText = amountText.replace(",", "");

            try {
                double value = Double.parseDouble(amountText);
                totalAmount += value;
            } catch (NumberFormatException e) {
                System.out.println("Could not parse amount: " + amountText);
            }
        }

        System.out.println("Total Amount: " + totalAmount + " USD");

        driver.quit();
    }
}
