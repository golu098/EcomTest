package com.shiv.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestingCode {
    WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setupBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
           driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }
        else{
            throw new IllegalArgumentException("no browser supported");
        }
        driver.get("https://www.programiz.com/java-programming/online-compiler/");
        driver.manage().window().maximize();
    }
    @Test
    public void a(){
        System.out.println(Thread.currentThread().getId());
    }
    @Test
    public void b(){

        System.out.println(Thread.currentThread().getId());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
