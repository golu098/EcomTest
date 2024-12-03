package com.shiv.SeleniumCode;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertClass {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-practice.netlify.app/alerts");
    }
    @Test
    public void alertMethod(){
        WebElement alertButton=driver.findElement(By.cssSelector("#alert-btn"));
        alertButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement confirmButton=driver.findElement(By.cssSelector("#confirm-btn"));
        confirmButton.click();
        alert.dismiss();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
