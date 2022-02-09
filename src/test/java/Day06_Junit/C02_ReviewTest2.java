package Day06_Junit;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
go to https://www.saucedemo.com
write "standard_user" in the username box
write "secret_sauce" in the password box
click on login
register/write the name of the first product and go to its page
click "add to chart" button
click on the 'shopping chart"
verify if the selected product has been added to the chart
close the page
 */
public class C02_ReviewTest2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));

        //  go to https://www.saucedemo.com
        driver.get("https://www.saucedemo.com");
        //  write "standard_user" in the username box
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //  write "secret_sauce" in the password box
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //  click on login
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //  register/write the name of the first product and go to its page
        WebElement firstItem = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        System.out.println(firstItem.getText());
        firstItem.click();
        //  click "add to chart" button
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //  click on the 'shopping chart"
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //  verify if the selected product has been added to the chart
        WebElement itemInChart = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        if (itemInChart.isDisplayed()) {
            System.out.println("The item is displayed");
        } else {
            System.out.println("The item is not displayed");
        }
        //  close the page
        driver.close();
    }
}
