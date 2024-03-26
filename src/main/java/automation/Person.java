package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter @AllArgsConstructor
@Data
public class Person {
    public final String lastName;
    public final String firstName;
    public final String email;
    public final String website;
    public final float due;
    public static Person toPerson(WebElement element) {
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstname = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        float due = Float.parseFloat(element.findElements(By.tagName("td")).get(3).getText().trim().replace("$", ""));
        String website = element.findElements(By.tagName("td")).get(4).getText();
        return new Person (firstname, lastName, email, website, due);
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public float getDue() {
        return due;
    }
}
