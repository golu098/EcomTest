package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {
    private WebDriver driver;

    // Locators
    private static final By NUMBER_LOCATOR = By.xpath("//input[@placeholder=\"Enter phone number\"]");
    private static final By STREET_LOCATOR = By.xpath("//input[@placeholder=\"5876 Little Streets\"]");
    private static final By CITY_LOCATOR = By.xpath("//input[@placeholder=\"London\"]");
    private static final By COUNTRY_DROPDOWN = By.id("countries_dropdown_menu");
    private static final By CHECKOUT_BUTTON =By.id("submitOrderBtn");
    private static final By SUCCESSFUL_MESSAGE = By.id("message");
//    private static final By STREET_LOCATOR = RelativeLocator.with(By.name("street")).below(NUMBER_LOCATOR);
//    private static final By CITY_LOCATOR = RelativeLocator.with(By.name("city")).below(STREET_LOCATOR);
//    private static final By COUNTRY_DROPDOWN = RelativeLocator.with(By.name("country")).below(CITY_LOCATOR);
//    private static final By CHECKOUT_BUTTON = RelativeLocator.with(By.id("submitOrderBtn")).below(COUNTRY_DROPDOWN);
//    private static final By SUCCESSFUL_MESSAGE = By.id("message");

    // Constructor
    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterPhone(String number) {
        waitForElementToBeVisible(NUMBER_LOCATOR).sendKeys(number);
    }

    public void enterStreet(String street) {
        waitForElementToBeVisible(STREET_LOCATOR).sendKeys(street);
    }

    public void enterCity(String city) {
        waitForElementToBeVisible(CITY_LOCATOR).sendKeys(city);
    }

    public void selectCountry(String countryName) {
        WebElement dropdown = waitForElementToBeVisible(COUNTRY_DROPDOWN);
        Select select = new Select(dropdown);
        select.selectByVisibleText(countryName);
    }

    public void submitOrder() {
        waitForElementToBeClickable(CHECKOUT_BUTTON).click();
    }

    public boolean isSuccessfulMessageDisplayed() {
        return waitForElementToBeVisible(SUCCESSFUL_MESSAGE).isDisplayed();
    }

    // Helper Methods for Explicit Waits
    private WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
