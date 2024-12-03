package com.shiv.SeleniumCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class MultipleWindowsExample {
    public static void main(String[] args) {
        // Setup WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the first window
        driver.get("https://chatgpt.com/c/674da80f-bd48-8002-a570-2434b7f851f3");

        // Store the current window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Open a new window/tab
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Navigate to a different page in the new window
        driver.get("https://qa-practice.netlify.app/tab");

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through the window handles and switch to the new window
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                // Perform actions on the new window
                System.out.println("Switched to window: " + driver.getTitle());
                // Close the new window after work is done
//                driver.close();
            }
        }

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Back to main window: " + driver.getTitle());

        // Close the main window
//        driver.quit();
    }
}
