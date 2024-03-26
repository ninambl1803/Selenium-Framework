package automation.theinternet;

import automation.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

public class ExampleForTesting {
    /*
    Open browser
    Navigate to https://the-internet.herokuapp.com/checkboxes
    Check on checkbox1
    Verify checkbox1 is checked
    Check on checkbox2
    Verify checkbox2 is checked
 */
    void verifyCheckBoxesAreSelected() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        checkbox1.click();
        if (!checkbox1.isSelected())
        {
            checkbox1.click();
        }
        Assert.assertTrue(checkbox1.isSelected(),"checkbox 2 is not selected");

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        checkbox2.click();
        if (!checkbox2.isSelected())
        {
            checkbox2.click();
        }
        Assert.assertTrue(checkbox2.isSelected(),"checkbox 2 is not selected");
    }
    /*
    Open browser
    Navigate to https://the-internet.herokuapp.com/dropdown
    Select "option 1"
    Validate "option 1" is selected
     */
    @Test
    void verifyOptionsAreSelected(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement select = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText("Option 1");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[.='Option 1']")).isSelected());
        dropdown.selectByVisibleText("Option 2");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[text()='Option 2']")).isSelected());
    }
    /*
    Open browser
    Navigate to https://the-internet.herokuapp.com/status_codes
    Click on "200"
    Then "200 status code" page appear
    Click on "go here"
    Click on "301"
    Then "301 status code" page appear
    Click on "go here"
    Click on "404"
    Then "404 status code" page appear
    Click on "go here"
    Click on "500"
    Then "500 status code" page appear
    Click on "go here"
     */
    @Test
    void verifyRedirector(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/redirector");

        driver.findElement(By.linkText("here")).click();// <----
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/200");
        String content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 200 status code."));

        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/404");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");
        driver.findElement(By.linkText("here")).click();
    }
    /*
    Open browser
    Navigate to https://the-internet.herokuapp.com/tables
    Focus on table 1
    The person who has largest due is "Doe Jacson"
     */

    @Test
    void verifyLargestPerson(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        List<Person> listPerson;
        listPerson = rows.stream()
                .map(Person::toPerson).collect(Collectors.toList());

        Person largestPerson = listPerson
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);

        Assert.assertEquals(String.format("%s %s", largestPerson.getLastName(), largestPerson.getFirstName()), "Jason Doe");
    }
    @Test
    void verifySmallestPerson(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        List<Person> listPerson2;
        listPerson2 = rows.stream()
                .map(Person::toPerson).collect(Collectors.toList());

        Person smallestPerson = listPerson2
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);

        Assert.assertEquals(String.format("%s %s", smallestPerson.getLastName(), smallestPerson.getFirstName()), "John Smith");
    }
}
