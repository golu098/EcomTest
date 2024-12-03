package com.shiv.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Checkout;
import pages.HomePage;
import pages.Login;

public class EcomTest {
    WebDriver driver;

    @Test
    public void ecomWorkFlow(){
        driver=new ChromeDriver();
        driver.navigate().to("https://qa-practice.netlify.app/auth_ecommerce");
        driver.manage().window().maximize();

        Login loginPage=new Login(driver);
        loginPage.enterEmail("admin@admin.com");
        loginPage.enterPassword("admin123");
        loginPage.submitButton();

        HomePage homePage=new HomePage(driver);

        homePage.addItemsToCart();
        homePage.validateCartDetails();
        homePage.proceedToCheckout();

        Checkout checkout=new Checkout(driver);
        checkout.enterPhone("6202002123");
        checkout.enterStreet("sh!k");
        checkout.enterCity("Patna");
        checkout.selectCountry("India");
        checkout.submitOrder();
        checkout.isSuccessfulMessageDisplayed();

    }
}
