package Day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_FirstTestMethod {

    WebDriver driver;
    @Test
    public void Test1 () {
    // go to www.amazon.com and verify that the title contains the word "amazon"
        driver.get("https://amazon.com");
        String actualTitle = driver.getTitle();
        String searchedword = "amazon";
        if (actualTitle.contains(searchedword)) {
            System.out.println("The title contains the word amazon");
        } else {
            System.out.println("\"The title does not contain the word amazon\"");
        }
    }
    @Test
    public void Test2 () {
    // go to www.google.com and verify that the title contains the word "google"
        driver.get("https://google.com");
        String actualTitle = driver.getTitle();
        String searchedword = "google";
        if (actualTitle.contains(searchedword)) {
            System.out.println("The title contains the word google");
        } else {
            System.out.println("The title does not contain the word google");
        }
    }

    @Before
    public void settings () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
    }

    @After
    public void tidyUp () {
        driver.close();
    }
}
