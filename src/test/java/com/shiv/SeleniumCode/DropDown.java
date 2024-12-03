package com.shiv.SeleniumCode;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDown {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-practice.netlify.app/dropdowns");
    }

    @Test
    public void dropDownChecking(){
        WebElement dropDown=driver.findElement(By.cssSelector("#dropdown-menu"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Afghanistan");
        select.selectByValue("American Samoa");
        select.selectByIndex(3);
    }
    @Test
    public void alertMethod(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
