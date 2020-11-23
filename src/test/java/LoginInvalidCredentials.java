import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class LoginInvalidCredentials {

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
        String alertMsg = "Invalid Username or Password";

        //insert invalid username
        driver.findElement(By.xpath("//input[@placeholder='you@example.com']")).sendKeys("adli.lantai30@gmail.com");
        //insert invalid password
        driver.findElement(By.xpath("//input[@formcontrolname='pass']")).sendKeys( "123123123");
        //click button Login
        driver.findElement(By.xpath("//form/button")).click();

        //wait for elements to show
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div[4]/b")));
        //actual: form contains Invalid Username or Password
        String actualAlertMsg = driver.findElement(By.xpath("//form/div[4]/b")).getText();
        //verify invalid credentials; expected: form must contains Invalid Username or Password
        assertEquals(actualAlertMsg, alertMsg);

        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println(bodyText);
    }

    @AfterTest
    public void AfterTest(){
        driver.quit();
    }
}
