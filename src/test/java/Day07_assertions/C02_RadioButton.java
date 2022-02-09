package Day07_assertions;

/*
Go to facebook
Accept cookies
click on the "Create an Account" button
Locate "radio button" elements
Select appropriate one for yourself if not selected
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButton {
    WebDriver driver;

    @Before
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        //  Go to facebook
        driver.get("https://facebook.com");
    }
    @Test
    public void test01 () {
        //  Accept cookies
        driver.findElement(By.xpath("//button[@title='Allow All Cookies']")).click();
        //  click on the "Create an Account" button
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //  Locate "radio button" elements
        driver.findElement(By.xpath("(//label[@class='_58mt'])[1]"));
        driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
        driver.findElement(By.xpath("(//label[@class='_58mt'])[3]"));
        //  Select appropriate one for yourself if not selected
        driver.findElement(By.xpath("(//label[@class='_58mt'])[2]")).click();
    }
    @After
    public void tearDown () {
        driver.close();
    }
}
