package Day05_BuildingMavenProjects;

/*
go to http://zero.webappsecurity.com
click on sign in
write "username" in username box
write "password" in password box
click on sign in
go to the "pay bills" page
write how much you want to deposit in amount section
write '20.09.10" on date section
click on "pay" button
check if "payment was successfully submitted" message appears
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        //  go to http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com");
        //  click on sign in
        driver.findElement(By.id("signin_button")).click();
        //  write "username" in login box
        driver.findElement(By.id("user_login")).sendKeys("username");
        //  write "password" in password box
        driver.findElement(By.id("user_password")).sendKeys("password");
        //  click on sign in
        driver.findElement(By.name("submit")).click();
        //  go to the "pay bills" page
        //  write how much you want to deposit in amount section
        //  write '20.09.10" on date section
        //  click on "pay" button
        //  check if "payment was successfully submitted" message appears

        driver.close();
    }
}
