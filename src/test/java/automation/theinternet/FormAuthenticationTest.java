package automation.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }
    @Test
    void loginSuccessfulWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
    }
        @Test
        void loginFailWithInvalidUsername(){
            driver.findElement(By.id("username")).sendKeys("tomsmithh");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.cssSelector("button[type=submit]")).click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
            Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid"));
        }
        @Test
        void loginFailWithInvalidPassword(){
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
            driver.findElement(By.cssSelector("button[type=submit]")).click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
            Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid"));
        }
        @Test
        void loginFailWithInvalidCredentials(){
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
            driver.findElement(By.cssSelector("button[type=submit]")).click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
            Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid"));
        }
        //@AfterClass
        //void tearDown(){
            //driver.quit();
        //}
}
