package com.shiv.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class ShoppingCart {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-practice.netlify.app/products_list");
    }

//    @Test
//    public void itemaddToCart(){
//        addItemToCart();
//    }
    @Test
    public void addItemToCart(){
        String [] itemsName={"Apple iPhone 12, 128GB, Black","Huawei Mate 20 Lite, 64GB, Black","Samsung Galaxy A32, 128GB, White"};
        String [] itemsPrices ={"$905.99","$236.12","$286.99"};
        for(String item:itemsName) {
//        for(int item=0;item<itemsName.length;item++){
            WebElement itemLocator = driver.findElement(By.xpath("//span[.=\"" + item + "\"]"));
            WebElement addtoCart1 = driver.findElement(RelativeLocator.with(By.tagName("button")).below(itemLocator));
            addtoCart1.click();
        }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-item-title")));

        // validating items
        List<WebElement> cartItems = driver.findElements(By.className("cart-item-title"));
        for(String expectedItemName : itemsName){
                boolean found = false;
                for(WebElement cartItemName : cartItems){
                    if(cartItemName.getText().equals(expectedItemName)){
                        found = true;
                        break;
                    }
                }
                Assert.assertTrue(found, "Item " + expectedItemName + " not found in the cart");
            }

        // validating prices
        List<WebElement>cartPrices=driver.findElements(By.xpath("//span[@class=\"cart-price cart-column\"]"));
            for(String expectedPrice:itemsPrices){
                boolean found=false;
                for(WebElement cartPrice:cartPrices){
                    if(cartPrice.getText().equals(expectedPrice)){
                        found=true;
                        break;
                    }
                }
                Assert.assertTrue(found, "Item"+expectedPrice+"is not matched");
            }

            // validating total price

            List<WebElement>cartQuant=driver.findElements(By.className("cart-quantity-input"));
            double totalPrice=0.0;
            for(int i=0;i<cartPrices.size();i++){
              String priceText=cartPrices.get(i).getText().replace("$","").trim();
              double price=Double.parseDouble(priceText);

              String quantText=cartQuant.get(i).getAttribute("value");
              int quantity=Integer.parseInt(quantText);
                totalPrice+=price*quantity;
          }
        // Format the total price to one decimal place
        String formattedTotalPrice = String.format("%.1f", totalPrice);
            double finalPrice=Double.parseDouble(formattedTotalPrice);
        System.out.println("Calculated Total prices :"+formattedTotalPrice);
          WebElement displayTotalPrice=driver.findElement(By.className("cart-total-price"));
          String displayPriceText=displayTotalPrice.getText().replace("$","").trim();
          double displayPrice=Double.parseDouble(displayPriceText);
        Assert.assertEquals(finalPrice, displayPrice, "Price not matched");

//        Assert.assertEquals(displayPrice, totalPrice, "Price not matched");


    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
