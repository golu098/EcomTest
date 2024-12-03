package com.shiv.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowCode {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://qa-practice.netlify.app/window");
        driver.manage().window().maximize();
    }
    @Test
    public void windowHandlingMethod(){
        WebElement pressMeButtonLocator=driver.findElement(By.id("newWindowBtn"));
        pressMeButtonLocator.click();
        String parentWindow=driver.getWindowHandle();
        Set<String> multipleWindow=driver.getWindowHandles();
        for(String i:multipleWindow){
            if(!i.equals(parentWindow)) {
                driver.switchTo().window(i);
                break;
            }
        }
        System.out.println(driver.getTitle()+" "+driver.getCurrentUrl());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle()+" "+driver.getCurrentUrl());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
