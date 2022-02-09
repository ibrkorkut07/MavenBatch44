package Day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
Go to https://www.youtube.com)
Build 4 test methods to carry out the following tests
1) titleTest => Verify that page title is "YouTube"
2) imageTest => Verify that YouTube image is displayed
3) Search Box is enabled
4) wrongTitleTest => Verify that page title is NOT “youtube”
 */
public class C05_YoutubeTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        //  Go to https://www.youtube.com)
        driver.get("https://www.youtube.com");
    }
    @Test
    public void titleTest () {
        //  Verify that page title is "YouTube"
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void imageTest () {
        //  imageTest => Verify that YouTube image is displayed
        WebElement tubeImagine = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[3]"));
        Assert.assertTrue(tubeImagine.isDisplayed());
    }
    @Test
    public void searchBoxTest () {
        //  Search Box is enabled
        WebElement searchBox = driver.findElement(By.xpath("(//input[@name='search_query'])[1]"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest () {
        //  Verify that page title is NOT “youtube”
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "youtube";
        Assert.assertFalse(expectedTitle2.equals(actualTitle2));
    }
    @AfterClass
    public static void tearDowm () {
        driver.close();
    }
}
