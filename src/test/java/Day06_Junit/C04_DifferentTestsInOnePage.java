package Day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_DifferentTestsInOnePage {
    static WebDriver driver;
    static WebElement searchBox;
    static WebElement searchResultElement;
    @Test
    public void test01 () {
    // search for nutella in amazon and verify tha the result contains nutella
        searchBox.sendKeys("nutella" + Keys.ENTER);
        searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualNutellaResult = searchResultElement.getText();
        String searchedword = "nutella";

        if (actualNutellaResult.contains(searchedword)) {
            System.out.println("It contains the word nutella");
        } else {
            System.out.println("It does not contain the word nutella");
        }
    }

    @Test
    public void test02 () {
        // search for java in amazon and verify tha the result contains java
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("java" + Keys.ENTER);
        searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualNutellaResult = searchResultElement.getText();
        String searchedword = "java";

        if (actualNutellaResult.contains(searchedword)) {
            System.out.println("It contains the word java");
        } else {
            System.out.println("It does not contain the word java");
        }
    }

    @Test
    public void test03 () {
        // search for ali in amazon and verify tha the result contains ali
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("ali" + Keys.ENTER);
        searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualNutellaResult = searchResultElement.getText();
        String searchedword = "ali";

        if (actualNutellaResult.contains(searchedword)) {
            System.out.println("It contains the word ali");
        } else {
            System.out.println("It does not contain the word ali");
        }
    }
    @BeforeClass
    public static void settings () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.get("https://amazon.com");
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));

    }

    @AfterClass
    public static void tidyUp () {
        driver.close();
    }
}
