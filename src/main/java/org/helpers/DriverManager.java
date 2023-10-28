package org.helpers;

import configurations.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class DriverManager {

    public static WebDriver driver;
    public static String downloadDir;
    public static WebDriverWait wait;

    public static void initDriver() {
        String browser = System.getProperty("browser");
        downloadDir = Paths.get("src/main/downloads").toAbsolutePath().toString();
        if (browser != null && browser.equals("chrome")) {
            System.setProperty(PropertiesManager.getChromeDriver(), PropertiesManager.getChromeDriverPath());
            driver = new ChromeDriver();
        } else {
            System.setProperty(PropertiesManager.getFirefoxDriver(), PropertiesManager.getFirefoxDriverPath());
            driver = new FirefoxDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(PropertiesManager.getWaitTime()));
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void quitDriver() {
        driver.quit();
    }
}
