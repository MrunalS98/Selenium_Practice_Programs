package JavaScript_User;

import com.MrunalSolanki.TestCase_BoilerPlate.Boiler_Plate_TC;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.MrunalSolanki.Wait_Helper.TestSelenium_WaitHelpers.waitJVM;

public class JS_Selenium_Prog extends Boiler_Plate_TC {

    @Test
    @Description("JS use in selenium")
    public void test_JS(){

        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        driver.manage().window().maximize();

        //JavascriptExecutor is a interface so you can't create a instance of it so just typecast your driver to it
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement scroll_down_to_element = driver.findElement(By.xpath("//div[@id='userName']"));

        //Scroll down to the element given by using js function
        js.executeScript("arguments[0].scrollIntoView(true);", scroll_down_to_element);
        //js.executeScript("window.scrollBy(0, 500);");

        //You can get url and title using js
        String url = js.executeScript("return document.URL;").toString();
        String title = js.executeScript("return document.title;").toString();

        System.out.println(url);
        System.out.println(title);

    }
}
