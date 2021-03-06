import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginUser {

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
    public void LoginAsUser(){
        //Audit Trail Log menu XPath
        String menuXpath = "(//a[@class='nav-link']/child::*)[6]";

        //insert username
        driver.findElement(By.xpath("//input[@placeholder='you@example.com']")).sendKeys("adli.lantai3.02@gmail.com");
        //insert password
        driver.findElement(By.xpath("//input[@formcontrolname='pass']")).sendKeys( "P@ssw0rd");
        //click button Login
        driver.findElement(By.xpath("//form/button")).click();

        //wait for elements to show
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nav-link']/child::*")));
        //verify user success login; expected: body must not contains Audit Trail Log menu
        assertTrue(driver.findElements(By.xpath(menuXpath)).isEmpty());

    }

    @AfterTest
    public void AfterTest(){
        driver.quit();
    }
}
