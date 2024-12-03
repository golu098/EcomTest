package com.shiv.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://example.com/dynamic-table"); // Replace with actual URL
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
