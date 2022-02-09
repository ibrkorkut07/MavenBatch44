package Day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/*
go to https://www.the-internet.heroku.com/checkboxes
Locate checkbox1 & checkbox2 elements
Click if checkbox1 is not ticked
Click if checkbox2 is not ticked
 */
public class C01_Checkboxes {

    WebDriver driver;
    @Before
    public void setup () {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
    }
    @Test
    public void test01 () throws InterruptedException {
        //    go to https://www.the-internet.heroku.com/checkboxes
        driver.get("https://www.the-internet.heroku.com/checkboxes");
        //    Locate checkbox1 & checkbox2 elements
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //    Click if checkbox1 is not checked
        Thread.sleep(3000);
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        //    Click if checkbox2 is not checked
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        Thread.sleep(3000);
    }

    @After
    public void tearDown () {
        driver.close();
    }

}
