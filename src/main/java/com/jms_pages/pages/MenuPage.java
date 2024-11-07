package com.jms_pages.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Clase que representa la página de Login utilizando Page Factory Pattern
 */
public class MenuPage {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    // Page elements
    @FindBy(xpath = "//span[@class='menu-title'][text()='Shop']")
    private WebElement l1_shopOption;

    @FindBy(xpath = "//span[@class='menu-title'][text()='Accessories']")
    private WebElement l2_accessoriesOption;

    @FindBy(xpath = "//span[@class='menu-title'][text()='Bags']")
    private WebElement l3_bagsOption;

    @FindBy(xpath = "//span[@class='menu-title'][text()='Evening Bags']")
    private WebElement l4_eveningBagsOption;

    /**
     * Constructor de la página de Login.
     *
     * @param driver WebDriver instance.
     */
    // Constructor
    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Métodos para interactuar con los elementos del menú
    public void level1_clickShopOption() {
        l1_shopOption.click();
    }

    public void level2_mouseOverAccessoriesOption() {
        actions.moveToElement(l2_accessoriesOption).perform();
    }

    public void level3_mouseOverBagsOption() {
        actions.moveToElement(l3_bagsOption).perform();
    }

    public void level4_clickEveningBagsOption() {
        l4_eveningBagsOption.click();
    }

    /**
     * Realiza el proceso de selección de la opción Evening Bags.
     *
     */
    public void selectEveningBags() {
        level1_clickShopOption();
        level2_mouseOverAccessoriesOption();
        level3_mouseOverBagsOption();
        level4_clickEveningBagsOption();
    }
}
