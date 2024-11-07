package com.jms_pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static DriverManager instance = null;
    private WebDriver driver;

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private DriverManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Obtiene la instancia única de DriverManager.
     *
     * @return DriverManager instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    /**
     * Obtiene el WebDriver actual.
     *
     * @return WebDriver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Cierra y elimina el WebDriver.
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null;
        }
    }
}
