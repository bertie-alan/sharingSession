import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class testNG {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void BeforeTest(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,30);
        driver.get("http://52.77.161.168/#/login");

    }

    @Test
    public void Test1(){
        //Login with xpath
        //insert username
        driver.findElement(By.xpath("//input[@placeholder='you@example.com']")).sendKeys("adli.lantai3@gmail.com");
        //insert password
        driver.findElement(By.xpath("//input[@formcontrolname='pass']")).sendKeys( "12345678");
        //click button Login
        driver.findElement(By.xpath("//form/button")).click();

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }


}
