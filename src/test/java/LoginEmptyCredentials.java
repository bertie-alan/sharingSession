import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class LoginEmptyCredentials {

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
    public void LoginInvalidCredentials(){
        String alertMsgUsername = "Username is required";
        String alertMsgPassword = "Password is required";

        //insert w/ empty username
        driver.findElement(By.xpath("//input[@placeholder='you@example.com']")).sendKeys("");
        //insert w/ empty password
        driver.findElement(By.xpath("//input[@formcontrolname='pass']")).sendKeys( "");
        //click button Login
        driver.findElement(By.xpath("//form/button")).click();

        //wait for elements to show
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Username is required')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Password is required')]")));

        //actual: show alert 'Username is required'
        String actualMsgUsername = driver.findElement(By.xpath("//div[contains(text(),'Username is required')]")).getText();
        //actual: show alert 'Password is required'
        String actualMsgPassword = driver.findElement(By.xpath("//div[contains(text(),'Password is required')]")).getText();
        //verify empty Username; expected: form must show alert 'Username is required'
        assertEquals(actualMsgUsername, alertMsgUsername);
        //verify empty Password; expected: form must show alert 'Password is required'
        assertEquals(actualMsgPassword, alertMsgPassword);
    }

    @AfterTest
    public void AfterTest(){
        driver.quit();
    }
}
