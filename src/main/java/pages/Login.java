package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Login {
    WebDriver driver;
    public  Login(WebDriver driver){
        this.driver=driver;
    }
    private static By emailId= By.cssSelector("#email");
    private static By password= RelativeLocator.with(By.tagName("input")).below(emailId);
    private static By submitButton=RelativeLocator.with(By.tagName("button")).below(password);
    public void enterEmail(String enterEmail) {
        driver.findElement(emailId).sendKeys(enterEmail);
    }

    public void enterPassword(String enterPassword) {
        driver.findElement(password).sendKeys(enterPassword);

    }

    public void submitButton() {
    driver.findElement(submitButton).click();
    }
}
