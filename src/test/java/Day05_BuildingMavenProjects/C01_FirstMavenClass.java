package Day05_BuildingMavenProjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
/*
go to amazon
locate search box
search for "Samsung headphones"
write the number of search results
click on the first search result
back to the previous page and write the number of all the headings
 */
public class C01_FirstMavenClass {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        // go to amazon
        driver.get("https://www.amazon.com/");
        // locate search box
        WebElement searchButton = driver.findElement(By.id("twotabsearchtextbox"));
        // search for "Samsung headphones"
        searchButton.sendKeys("Samsung Headphones" + Keys.ENTER);
        // write the number of search results
        WebElement numberofHeadPhones = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(numberofHeadPhones.getText());
        // click on the first search result
        numberofHeadPhones.click();
        WebElement firstProduct = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstProduct.click();
        driver.navigate().back();
        // back to the previous page and write the number of all the headings
        List<WebElement> list = driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        System.out.println(list.size());

        driver.close();





    }
}
