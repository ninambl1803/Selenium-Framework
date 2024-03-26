package automation.theinternet;

import automation.csv.beans.LoginBean;
import automation.csv.examples.sync.CsvReaderExamples;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileAuthenticationTest {
    List<LoginBean> lstLogin;
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        try {
            Path path = Paths.get("csv/Data test.csv");
            lstLogin = CsvReaderExamples.loadLoginList(path, LoginBean.class);
        }catch (Exception ex)
        {
            System.out.println("Cannot load csv file: " + ex.toString());
        }
    }
    @Test
    void loginSuccessfulWithValidCredentials() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        for (int i = 0; i < lstLogin.size(); i++) {
            System.out.println("test with user name: " + lstLogin.get(i).getUsername());
            Reporter.log("test with user name: " + lstLogin.get(i).getUsername());
            driver.findElement(By.id("username")).sendKeys(lstLogin.get(i).getUsername());
            driver.findElement(By.id("password")).sendKeys(lstLogin.get(i).getPassword());
            driver.findElement(By.cssSelector("button[type=submit]")).click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
            Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
        }
    }
}
