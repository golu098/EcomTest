package com.shiv.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginClass {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-practice.netlify.app/auth_ecommerce");

    }

    @Test
    public void loginMethod(){
        WebElement emailLocator=driver.findElement(By.cssSelector("#email"));
        WebElement passwordLocator = driver.findElement(RelativeLocator.with(By.tagName("input")).below(emailLocator));

        WebElement submitButtonLocator=driver.findElement(RelativeLocator.with(By.tagName("button")).near(passwordLocator));
        passwordLocator.sendKeys("admin123");
        emailLocator.sendKeys("admin@admin.com");
        submitButtonLocator.click();

        boolean isLoginSuccessfully=driver.findElement(By.cssSelector(".section-header")).isDisplayed();
        if(isLoginSuccessfully){
            System.out.println("Login successfully");
            WebElement logoutLocator=driver.findElement(By.cssSelector("#logout"));
            logoutLocator.click();

        }
        else{
            WebElement errorMessageocator=driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
            Assert.assertTrue(errorMessageocator.isDisplayed(), "Error msg is not locator");
            System.out.println("Login failed "+errorMessageocator.getText());

        }

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
