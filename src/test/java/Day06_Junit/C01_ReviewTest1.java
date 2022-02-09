package Day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/*
go to google.com
close cookies by accepting
Test if the page headline contains the word "google"
Search for "Nutella"
write the number of the results
Test if the the number of the results are over 10 million
close the page
 */
public class C01_ReviewTest1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        //  go to google.com
        driver.get("https://google.com");
        //  close cookies by accepting
        driver.findElement(By.xpath("(//div[@role='none'])[5]")).click();
        //  Test if the page headline contains the word "google"
        String title = driver.getTitle();
        String expected = "google";
        if (title.contains(expected)) {
            System.out.println("The title contains the word google");
        } else {
            System.out.println("The title does not contain the word google");
        }
        //  Search for "Nutella"
        WebElement searchbox = driver.findElement(By.xpath("//input[@jsaction='paste:puy29d;']"));
        searchbox.sendKeys("Nutella");
        searchbox.submit();
        //  write the number of the results
        String numberofResultsText = driver.findElement(By.id("result-stats")).getText();
        System.out.println(numberofResultsText);
        //  Test if the the number of the results are over 10 million
        String resultwords [] = numberofResultsText.split(" "); // Depends on the format the numbers
        // System.out.println(Arrays.toString(resultwords));
        String resultnumber = resultwords[1];
        resultnumber = resultnumber.replace(".", "");
        int nutellasearchresult = Integer.parseInt(resultnumber);

        if (nutellasearchresult>10000000) {
            System.out.println("The number is bigger than 10 million");
        } else {
            System.out.println("The number is not bigger than 10 million");
        }
        driver.close();
    }
}
