import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Login {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.get("http://52.77.161.168/#/login");

        //Login dengan xpath
        //insert username
        driver.findElement(By.xpath("//input[@placeholder='you@example.com']")).sendKeys("adli.lantai3@gmail.com");
        //insert password
        driver.findElement(By.xpath("//input[@formcontrolname='pass']")).sendKeys( "12345678");
        //click button Login
        driver.findElement(By.xpath("//form/button")).click();

        /* dari sharing session
        //cari elements username fields
        driver.findElement(By.xpath("//form/div[1]/input")).sendKeys("adli.lantai3@gmail.com");
        //cari elements password fields
        driver.findElement(By.id("pass")).sendKeys( "12345678");
        //click login button
        driver.findElement(By.xpath("//form/button")).click();*/

        //verify user sukses login, sidebar contain text logout
        String logoutText = driver.findElement(By.tagName("body")).getText();
        System.out.println(logoutText);

        //actualnya, body ada text logout - logoutText must contain LogOut

        assertThat(logoutText, containsString("Log Out"));



    }
}
