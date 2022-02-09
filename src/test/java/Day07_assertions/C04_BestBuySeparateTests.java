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
import org.openqa.selenium.remote.codec.w3c.W3CHttpCommandCodec;

import java.time.Duration;

public class C04_BestBuySeparateTests {
    static WebDriver driver;
    @BeforeClass
    public static void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        // Go to https://www.bestbuy.com/
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void urlTest() {
        //  Verify/Test that the web url is equal to https://www.bestbuy.com/
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.bestbuy.com/";
        Assert.assertEquals("Please, check the url values", expectedURL, actualURL);
    }
    @Test
    public void titleTest() {
        //  Verify/Test that page heading does not contain “Rest” (titletest)
        String actualTitle = driver.getTitle();
        String wordChecked = "Rest";
        Assert.assertFalse(actualTitle.contains(wordChecked));
        }
    @Test
    public void logoTest() {
        //  Verify/Test BestBuy logo is displayed (logoTest)
        WebElement logo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo is not displayed", logo.isDisplayed());
        //  Verify/Test French link (Francais) is displayed (LinkTest)
    }
    @Test
    public void languageTest() {
        //  Verify/Test French link (Francais) is displayed (LinkTest)
        WebElement inFrench = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Francais is not displayed", inFrench.isDisplayed());
    }
    @AfterClass
    public static void tearDown () {
        driver.close();
    }
}
