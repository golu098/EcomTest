package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    // Locators
    private static final By PRICE_DETAILS = By.className("shop-item-price");
    private static final By ITEM_NAME = By.className("shop-item-title");
    private static final By ADD_TO_CART_BUTTON = RelativeLocator.with(By.tagName("button")).below(PRICE_DETAILS);
    private static final By CART_ITEMS = By.className("cart-item-title");
    private static final By CART_QUANTITIES = By.className("cart-quantity-input");
    private static final By CART_PRICES = By.xpath("//span[@class=\"cart-price cart-column\"]");
    private static final By CART_TOTAL_PRICE = By.className("cart-total-price");
    private static final By CHECKOUT_BUTTON = RelativeLocator.with(By.tagName("button")).below(CART_PRICES);

    // Test Data
    private final String[] itemsName = {
            "Apple iPhone 12, 128GB, Black",
            "Huawei Mate 20 Lite, 64GB, Black",
            "Samsung Galaxy A32, 128GB, White"
    };

    private final String[] itemsPrices = {
            "$905.99",
            "$236.12",
            "$286.99"
    };

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Add all items to the cart
    public void addItemsToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (String itemName : itemsName) {
            // Locate product by its name using an explicit XPath
            WebElement product = driver.findElement(By.xpath("//span[.=\"" + itemName + "\"]"));

            // Wait for the add to cart button to become clickable
            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                    RelativeLocator.with(By.tagName("button")).below(product)
            ));

            // Click the add-to-cart button
            addToCart.click();
            System.out.println("Added to cart: " + itemName);

            // Ensure that the cart updates and the item is added before moving to the next item
            wait.until(ExpectedConditions.presenceOfElementLocated(CART_ITEMS));
        }
    }

    // Validate cart details
    public void validateCartDetails() {
        // Validate item names in the cart
        List<WebElement> cartItemsList = driver.findElements(CART_ITEMS);
        for (String expectedItemName : itemsName) {
            boolean found = false;
            for (WebElement cartItemName : cartItemsList) {
                if (cartItemName.getText().equals(expectedItemName)) {
                    found = true;
                    break;
                }
            }
            assert found : "Item not found in cart: " + expectedItemName;
        }

        // Validate item prices in the cart
        List<WebElement> cartPricesList = driver.findElements(CART_PRICES);
        for (String expectedPrice : itemsPrices) {
            boolean found = false;
            for (WebElement cartPrice : cartPricesList) {
                if (cartPrice.getText().equals(expectedPrice)) {
                    found = true;
                    break;
                }
            }
            assert found : "Price not found in cart: " + expectedPrice;
        }

        // Calculate total price
        List<WebElement> cartQuantList = driver.findElements(CART_QUANTITIES);
        double totalPrice = 0.0;
        for (int i = 0; i < cartPricesList.size(); i++) {
            String priceText = cartPricesList.get(i).getText().replace("$", "").trim();
            double price = Double.parseDouble(priceText);

            String quantText = cartQuantList.get(i).getAttribute("value");
            int quantity = Integer.parseInt(quantText);

            totalPrice += price * quantity;
        }

        // Compare calculated total price with displayed total price
        String formattedTotalPrice = String.format("%.1f", totalPrice);
        WebElement displayedTotalPriceElement = driver.findElement(CART_TOTAL_PRICE);
        String displayedTotalPrice = displayedTotalPriceElement.getText().replace("$", "").trim();

        assert formattedTotalPrice.equals(displayedTotalPrice) :
                "Total price mismatch! Calculated: $" + formattedTotalPrice + ", Displayed: $" + displayedTotalPrice;
        System.out.println("Cart validation successful. Total Price: $" + formattedTotalPrice);
    }

    // Proceed to checkout
    public void proceedToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
        System.out.println("Proceeded to checkout.");
    }
}
